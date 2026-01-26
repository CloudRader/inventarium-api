package com.cloudrader.inventarium.model

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "oidc")
data class OidcProperties(
    val clientId: String,
    val clientSecret: String,
    val endSessionEndpoint: String?,
    val userInfoEndpoint: String,
)

@Configuration
@EnableConfigurationProperties(OidcProperties::class)
class PropertiesConfig