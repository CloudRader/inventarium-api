package com.cloudrader.inventarium.config.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

//@ResponseStatus(code = HttpStatus.CONFLICT)
class ConflictException(message : String) : AppException(message, HttpStatus.CONFLICT)