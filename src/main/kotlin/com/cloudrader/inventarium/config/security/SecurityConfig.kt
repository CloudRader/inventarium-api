package com.cloudrader.inventarium.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint

@Configuration
class SecurityConfig {
    @Bean
    fun oauth2FilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .csrf { it.disable() }
            .authorizeExchange { exchanges ->
                exchanges
                    .pathMatchers("/", "/.well-known/**", "/swagger-ui/**", "/api-docs/**").permitAll()
                    .anyExchange().authenticated()
            }
            .oauth2ResourceServer { oauth2 -> oauth2.jwt { } }
            .exceptionHandling { exceptions ->
                exceptions.authenticationEntryPoint(HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
            }
            .build()
    }
}
