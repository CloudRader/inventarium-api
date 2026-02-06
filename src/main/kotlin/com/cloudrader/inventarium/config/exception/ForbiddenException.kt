package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus

class ForbiddenException(message: String) : AppException(message, HttpStatus.FORBIDDEN)