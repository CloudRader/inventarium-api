package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.config.annotation.AuthenticatedAccount
import com.cloudrader.inventarium.dto.TenantCreateDto
import com.cloudrader.inventarium.dto.TenantDto
import com.cloudrader.inventarium.service.TenantService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Tenants", description = "Operations with tenants.")
@AuthenticatedAccount
@RequestMapping("/v1/tenants")
class TenantController(
    private val tenantService: TenantService
) {
    @Operation(
        security = [SecurityRequirement(name = "basicAuth")]
    )
    @PostMapping
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "409", description = "Conflict", content = [Content()]),
        ]
    )
    @ResponseStatus(HttpStatus.OK)
    fun createTenant(
        tenantCreate: TenantCreateDto
    ): TenantDto {
        return tenantService.createTenant(tenantCreate)
    }
}