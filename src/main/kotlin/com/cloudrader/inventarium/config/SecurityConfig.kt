package com.cloudrader.inventarium.config

import jakarta.servlet.DispatcherType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.HttpStatusEntryPoint

@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/")
                    .permitAll()
                    .requestMatchers(
//                        "/v1/auth/**",
//                        "/**" // TODO fixed, for develop purpose,
                        "/swagger-ui/**",
                        "/api-docs/**"
                    )
                    .permitAll()
                    .dispatcherTypeMatchers(
                        DispatcherType.ERROR,
                        DispatcherType.FORWARD
                    )
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .oauth2ResourceServer { it.jwt { } }
            .exceptionHandling { configurer ->
                configurer
                    .authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            }
            .build()
    }
}