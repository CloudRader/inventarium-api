package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus

class ConflictException(message : String) : AppException(message, HttpStatus.CONFLICT)