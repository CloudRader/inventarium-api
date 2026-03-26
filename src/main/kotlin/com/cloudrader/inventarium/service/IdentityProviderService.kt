package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.infrastructure.identityprovider.OpenIdConnectClient
import com.cloudrader.inventarium.infrastructure.repository.identityprovider.IdentityProviderRepository
import com.cloudrader.inventarium.infrastructure.repository.tenant.TenantRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.config.logging.log
import com.cloudrader.inventarium.domain.dto.identityprovider.IdentityProviderCreateDto
import com.cloudrader.inventarium.domain.mappers.toDto
import com.cloudrader.inventarium.domain.mappers.toModel
import com.cloudrader.inventarium.utils.security.AesSecretEncryptionService
import org.springframework.stereotype.Service

@Service
class IdentityProviderService(
    private val identityProviderRepository: IdentityProviderRepository,
    private val tenantRepository: TenantRepository,
    private val openIdConnectClient: OpenIdConnectClient,
    private val secretEncryptionService: AesSecretEncryptionService
) {
    suspend fun create(tenantAlias: String, identityProviderCreate: IdentityProviderCreateDto): Any {
        val identityProviderInfo = openIdConnectClient.getIssuerInfo(
            identityProviderCreate.configurationEndpoint
        )

        val tenant = tenantRepository.findByAlias(tenantAlias)
            ?: run {
                log.warn("Tenant with alias={} not found", tenantAlias)
                throw NotFoundException("Tenant with alias '$tenantAlias' not found")
            }

        val encryptedSecret = secretEncryptionService.encrypt(identityProviderCreate.clientSecret)

        return identityProviderRepository.save(identityProviderCreate
            .toModel(requireNotNull(tenant.id), encryptedSecret, identityProviderInfo)).toDto()
    }
}
