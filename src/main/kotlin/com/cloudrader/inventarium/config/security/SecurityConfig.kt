package com.cloudrader.inventarium.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint

@Configuration
class SecurityConfig {

    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    @Bean
    fun basicAdminFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain
    {
        return http
            .csrf { it.disable() }
            .authorizeExchange { exchanges ->
                exchanges
                    .pathMatchers("/v1/tenants").hasRole("PLATFORM_ADMIN")
                    .anyExchange().authenticated()
            }
            .httpBasic { }  // optional
            .exceptionHandling { exceptions ->
                exceptions.authenticationEntryPoint(HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
            }
            .build()
    }
//    }
//        return http
//            .securityMatcher("/v1/tenants")
//            .csrf { it.disable() }
//            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
//            .authorizeHttpRequests { auth ->
//                auth.anyRequest().hasRole("PLATFORM_ADMIN")
//            }
//            .httpBasic { }
//            .exceptionHandling {
//                it.authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//            }
//            .build()
//    }

    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
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
//        return http
//            .csrf { it.disable() }
//            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
//            .authorizeHttpRequests { auth ->
//                auth
//                    .requestMatchers("/").permitAll()
//                    .requestMatchers("/.well-known/**", "/swagger-ui/**", "/api-docs/**").permitAll()
//                    .dispatcherTypeMatchers(
//                        DispatcherType.ERROR,
//                        DispatcherType.FORWARD
//                    )
//                    .permitAll().anyRequest().authenticated()
//            }
//            .oauth2ResourceServer { it.jwt { } }
//            .exceptionHandling {
//                it.authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//            }
//            .build()
    }
}
