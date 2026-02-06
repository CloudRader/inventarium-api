package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus

class NotFoundException(message: String) : AppException(message, HttpStatus.NOT_FOUND)