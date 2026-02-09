package com.cloudrader.inventarium.config.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun buildError(
    ex: Exception,
    request: HttpServletRequest,
    status: HttpStatus
): ResponseEntity<ApiError> {

    val body = ApiError(
        status = status.value(),
        error = status.reasonPhrase,
        message = ex.message ?: "Unexpected error",
        path = request.requestURI
    )

    return ResponseEntity.status(status).body(body)
}
