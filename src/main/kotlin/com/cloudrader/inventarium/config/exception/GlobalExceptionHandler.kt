package com.cloudrader.inventarium.config.exception

import jakarta.servlet.http.HttpServletRequest
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import com.cloudrader.inventarium.config.logging.log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleConflict(
        ex: DataIntegrityViolationException,
        request: HttpServletRequest
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
            request.requestURI,
            constraintName,
            ex.message,
        )

        return buildError(
            RuntimeException(message),
            request,
            HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(
        ex: NotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ApiError> = buildError(ex, request, HttpStatus.NOT_FOUND)

    private fun extractConstraintName(ex: Throwable): String? {
        var cause: Throwable? = ex
        while (cause != null) {
            if (cause is ConstraintViolationException) {
                return cause.constraintName
            }
            cause = cause.cause
        }
        return null
    }
}