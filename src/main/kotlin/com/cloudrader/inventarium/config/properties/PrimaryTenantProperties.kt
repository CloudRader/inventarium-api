package com.cloudrader.inventarium.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("tenant")
data class PrimaryTenantProperties(
    val name: String,
    val alias: String,
)
