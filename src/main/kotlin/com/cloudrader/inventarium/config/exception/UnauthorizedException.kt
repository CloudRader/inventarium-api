package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus

class UnauthorizedException(message: String) : AppException(message, HttpStatus.UNAUTHORIZED)