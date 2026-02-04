package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus

open class AppException(
    message: String,
    val status: HttpStatus
) : RuntimeException(message)


