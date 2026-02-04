package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

//@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(message: String) : AppException(message, HttpStatus.NOT_FOUND)