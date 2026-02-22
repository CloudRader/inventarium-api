package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.server.ServerWebExchange

fun buildError(
    ex: Exception,
    exchange: ServerWebExchange,
    status: HttpStatus
): ResponseEntity<ApiError> {

    val body = ApiError(
        status = status.value(),
        error = status.reasonPhrase,
        message = ex.message ?: "Unexpected error",
        path = exchange.request.path.value()
    )

    return ResponseEntity.status(status).body(body)
}
