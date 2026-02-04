package com.cloudrader.inventarium.controller.responces

import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ApiResponses(
    value = [
        ApiResponse(responseCode = "401", description = "Unauthorized", content = [Content()]),
        ApiResponse(responseCode = "403", description = "Forbidden", content = [Content()])
    ]
)
annotation class FullAuthorizedAccount
