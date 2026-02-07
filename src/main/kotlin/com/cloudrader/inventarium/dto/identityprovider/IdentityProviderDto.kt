package com.cloudrader.inventarium.dto.identityprovider

import java.util.UUID

data class IdentityProviderDto(
    val id: UUID,

    val tenantId: UUID,

    val type: String,
    val name: String,
    val alias: String,

    val clientId: String,
    val configurationEndpoint: String,
    val enabled: Boolean,
)