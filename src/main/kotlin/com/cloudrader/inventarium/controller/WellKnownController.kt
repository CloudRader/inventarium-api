package com.cloudrader.inventarium.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Well Known", description = "Application health and readiness endpoints")
@RequestMapping("/.well-known")
class WellKnownController {

    @Operation(
        summary = "Check application liveness",
        description = "Liveness probe used to verify that the application process is running."
    )
    @GetMapping("/live")
    fun live() {
        // OK
    }

    @Operation(
        summary = "Check application readiness",
        description = "Readiness probe used to determine whether the application is ready to accept incoming requests."
    )
    @GetMapping("/ready")
    fun ready() {
        // OK
    }
}
