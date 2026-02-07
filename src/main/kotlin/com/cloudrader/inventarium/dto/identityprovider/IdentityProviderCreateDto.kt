package com.cloudrader.inventarium.dto.identityprovider

data class IdentityProviderCreateDto(
    val type: String,
    val name: String,
    val alias: String,
    val configurationEndpoint: String,
    val clientId: String,
    val clientSecret: String,
)
