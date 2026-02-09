package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus

class BadRequestException(message: String) : AppException(message, HttpStatus.BAD_REQUEST)
