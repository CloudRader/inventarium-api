package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.identityprovider.OpenIdConnectClient
import com.cloudrader.inventarium.adapter.repository.IdentityProviderRepository
import com.cloudrader.inventarium.adapter.repository.TenantRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderCreateDto
import com.cloudrader.inventarium.mappers.toDto
import com.cloudrader.inventarium.mappers.toModel
import com.cloudrader.inventarium.utils.security.AesSecretEncryptionService
import org.springframework.stereotype.Service

@Service
class IdentityProviderService(
    private val identityProviderRepository: IdentityProviderRepository,
    private val tenantRepository: TenantRepository,
    private val openIdConnectClient: OpenIdConnectClient,
    private val secretEncryptionService: AesSecretEncryptionService
) {
    fun create(tenantAlias: String, identityProviderCreate: IdentityProviderCreateDto): Any {
        val identityProviderInfo = openIdConnectClient.getIssuerInfo(
            identityProviderCreate.configurationEndpoint
        )

        val tenant = tenantRepository.findByAlias(tenantAlias)
            ?: throw NotFoundException("Tenant with alias '$tenantAlias' not found")

        val encryptedSecret = secretEncryptionService.encrypt(identityProviderCreate.clientSecret)

        return identityProviderRepository.save(identityProviderCreate
            .toModel(tenant.id, encryptedSecret, identityProviderInfo)).toDto()
    }
}
