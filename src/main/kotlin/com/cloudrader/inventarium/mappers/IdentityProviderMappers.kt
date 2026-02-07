package com.cloudrader.inventarium.mappers

import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderDto
import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderCreateDto
import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.model.IdentityProvider
import java.util.UUID

fun IdentityProvider.toDto(): IdentityProviderDto {
    return IdentityProviderDto(
        id = this.id,
        tenantId = this.tenantId,
        type = this.type,
        name = this.name,
        alias = this.alias,
        clientId = this.clientId,
        configurationEndpoint = this.configurationEndpoint,
        enabled = this.enabled,
    )
}

fun IdentityProviderCreateDto.toModel(
    tenantId: UUID,
    encryptedSecret: String,
    identityProviderInfo: IdentityProviderIssuerInfoDto,
): IdentityProvider {

    return IdentityProvider(
        tenantId = tenantId,
        type = this.type,
        name = this.name,
        alias = this.alias,
        configurationEndpoint = this.configurationEndpoint,

        clientId = this.clientId,
        clientSecretHashed = encryptedSecret,

        issuer = identityProviderInfo.issuer,
        authorizationEndpoint = identityProviderInfo.authorizationEndpoint,
        tokenEndpoint = identityProviderInfo.tokenEndpoint,
        userinfoEndpoint = identityProviderInfo.userinfoEndpoint,
        endSessionEndpoint = identityProviderInfo.endSessionEndpoint,
        jwksUri = identityProviderInfo.jwksUri,
        scopesSupported = identityProviderInfo.scopesSupported.joinToString(",")
    )
}
