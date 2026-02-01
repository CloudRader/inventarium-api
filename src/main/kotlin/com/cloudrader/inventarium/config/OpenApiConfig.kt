package com.cloudrader.inventarium.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.security.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun openAPI(): OpenAPI =
        OpenAPI()
            .components(
                Components().addSecuritySchemes(
                    "oauth2",
                    SecurityScheme()
                        .type(SecurityScheme.Type.OAUTH2)
                        .flows(
                            OAuthFlows()
                                .authorizationCode(
                                    OAuthFlow()
                                        .authorizationUrl(
                                            "http://localhost:9000/application/o/authorize/"
                                        )
                                        .tokenUrl(
                                            "http://localhost:9000/application/o/token/"
                                        )
                                        .scopes(
                                            Scopes()
                                                .addString("openid", "OpenID")
                                                .addString("profile", "Profile")
                                                .addString("email", "Email")
                                        )
                                )
                        )
                )
                    .addSecuritySchemes(
                        "basicAuth",
                        SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("basic")
                            .description("Admin login with username and password")
                    )
            )
            .addSecurityItem(SecurityRequirement().addList("oauth2"))
}