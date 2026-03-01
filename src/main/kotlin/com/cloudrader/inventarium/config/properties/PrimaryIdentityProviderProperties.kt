package com.cloudrader.inventarium.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("identityprovider")
data class PrimaryIdentityProviderProperties(
    val type: String,
    val name: String,
    val alias: String,
    val configurationEndpoint: String,
    val clientId: String,
    val clientSecret: String,
)
