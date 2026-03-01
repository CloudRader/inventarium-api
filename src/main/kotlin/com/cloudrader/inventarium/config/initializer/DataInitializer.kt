package com.cloudrader.inventarium.config.initializer

import com.cloudrader.inventarium.adapter.identityprovider.OpenIdConnectClient
import com.cloudrader.inventarium.adapter.repository.identityprovider.IdentityProviderRepository
import com.cloudrader.inventarium.adapter.repository.tenant.TenantRepository
import com.cloudrader.inventarium.config.properties.PrimaryIdentityProviderProperties
import com.cloudrader.inventarium.config.properties.PrimaryTenantProperties
import com.cloudrader.inventarium.model.IdentityProvider
import com.cloudrader.inventarium.model.Tenant
import com.cloudrader.inventarium.utils.security.SecretEncryptionService
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val tenantRepository: TenantRepository,
    private val identityProviderRepository: IdentityProviderRepository,
    private val openIdConnectClient: OpenIdConnectClient,
    private val primaryTenantProperties: PrimaryTenantProperties,
    private val primaryIdentityProviderProperties: PrimaryIdentityProviderProperties,
    private val secretEncryptionService: SecretEncryptionService
) {
    @EventListener(ApplicationReadyEvent::class)
    suspend fun init() {
        val tenant = tenantRepository.findByAlias(primaryTenantProperties.alias)
            ?: tenantRepository.save(
                Tenant(
                    name = primaryTenantProperties.name,
                    alias = primaryTenantProperties.alias,
                )
            )

        identityProviderRepository.findByAlias(primaryIdentityProviderProperties.alias)
            ?: run {
                val identityProviderInfo = openIdConnectClient.getIssuerInfo(
                    primaryIdentityProviderProperties.configurationEndpoint
                )
                val encryptedSecret = secretEncryptionService.encrypt(
                    primaryIdentityProviderProperties.clientSecret
                )

                identityProviderRepository.save(
                    IdentityProvider(
                        tenantId = tenant.id!!,
                        type = primaryIdentityProviderProperties.type,
                        name = primaryIdentityProviderProperties.name,
                        alias = primaryIdentityProviderProperties.alias,
                        configurationEndpoint = primaryIdentityProviderProperties.configurationEndpoint,
                        clientId = primaryIdentityProviderProperties.clientId,
                        clientSecretHashed = encryptedSecret,
                        issuer = identityProviderInfo.issuer,
                        authorizationEndpoint = identityProviderInfo.authorizationEndpoint,
                        tokenEndpoint = identityProviderInfo.tokenEndpoint,
                        userinfoEndpoint = identityProviderInfo.userinfoEndpoint,
                        endSessionEndpoint = identityProviderInfo.endSessionEndpoint,
                        jwksUri = identityProviderInfo.jwksUri,
                        scopesSupported = identityProviderInfo.scopesSupported.joinToString(",")
                    )
                )
            }
    }
}
