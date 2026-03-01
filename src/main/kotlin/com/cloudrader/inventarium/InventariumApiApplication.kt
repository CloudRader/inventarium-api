package com.cloudrader.inventarium

import com.cloudrader.inventarium.config.properties.PrimaryIdentityProviderProperties
import com.cloudrader.inventarium.config.properties.PrimaryTenantProperties
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
	PrimaryTenantProperties::class, PrimaryIdentityProviderProperties::class
)
class InventariumApiApplication

fun main(args: Array<String>) {
	runApplication<InventariumApiApplication>(*args) {
		setWebApplicationType(WebApplicationType.REACTIVE)
	}
}
