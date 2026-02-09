package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.adapter.repository.IdentityProviderRepository
import com.cloudrader.inventarium.controller.responces.ConflictResponse
import com.cloudrader.inventarium.controller.responces.NotFoundResponse
import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderCreateDto
import com.cloudrader.inventarium.service.IdentityProviderService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Identity Providers", description = "Operations with identity providers.")
@RequestMapping("/v1/tenants/{tenantAlias}/identity-providers")
class IdentityProviderController(
    private val identityProviderService: IdentityProviderService,
) {

    @PostMapping
    @ConflictResponse
    @NotFoundResponse
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @PathVariable tenantAlias: String,
        @RequestBody identityProviderCreate: IdentityProviderCreateDto
    ): Any {
        return identityProviderService.create(tenantAlias, identityProviderCreate)
    }
}
