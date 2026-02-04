package com.cloudrader.inventarium.controller.responces

import com.cloudrader.inventarium.config.exception.ApiError
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ApiResponse(
    responseCode = "409",
    description = "Conflict / already exists",
    content = [Content(
        mediaType = "application/json",
        schema = Schema(implementation = ApiError::class)
    )]
)
annotation class ConflictResponse