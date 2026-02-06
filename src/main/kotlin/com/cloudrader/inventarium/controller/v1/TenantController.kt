package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.controller.responces.AuthenticatedAccount
import com.cloudrader.inventarium.controller.responces.ConflictResponse
import com.cloudrader.inventarium.controller.responces.NotFoundResponse
import com.cloudrader.inventarium.dto.tenant.TenantCreateDto
import com.cloudrader.inventarium.dto.tenant.TenantDto
import com.cloudrader.inventarium.service.TenantService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

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
    @ConflictResponse
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        tenantCreate: TenantCreateDto
    ): TenantDto {
        return tenantService.create(tenantCreate)
    }

    @GetMapping("/{id}")
    @NotFoundResponse
    @ResponseStatus(HttpStatus.OK)
    fun get(
        @PathVariable id: UUID
    ): TenantDto {
        return tenantService.get(id)
    }
}