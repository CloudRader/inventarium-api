package com.cloudrader.inventarium.config.exception

import org.springframework.dao.DataIntegrityViolationException
import com.cloudrader.inventarium.config.logging.log
import io.r2dbc.spi.R2dbcDataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ServerWebExchange

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleConflict(
        ex: DataIntegrityViolationException,
        exchange: ServerWebExchange,
    ): ResponseEntity<ApiError> {

        val constraintName = extractConstraintName(ex)

        val message = constraintName
            ?.removeSuffix("_uq")
            ?.removeSuffix("_key")
            ?.substringAfter("_")
            ?.let { field ->
                "${field.replaceFirstChar { it.uppercase() }} already exists"
            }
            ?: "Database constraint violation"

        log.warn(
            "Data integrity violation at path '{}', constraint='{}', message='{}'",
            exchange.request.path.value(),
            constraintName,
            ex.message,
        )

        return buildError(
            RuntimeException(message),
            exchange,
            HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(
        ex: NotFoundException,
        exchange: ServerWebExchange,
    ): ResponseEntity<ApiError> = buildError(ex, exchange, HttpStatus.NOT_FOUND)

    private fun extractConstraintName(ex: Throwable): String? {
        var cause: Throwable? = ex
        while (cause != null) {
            when (cause) {
                is R2dbcDataIntegrityViolationException -> return cause.message
            }
            cause = cause.cause
        }
        return null
    }
}
