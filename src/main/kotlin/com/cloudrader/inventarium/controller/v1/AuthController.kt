package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.dto.UserDto
import com.cloudrader.inventarium.model.User
import com.cloudrader.inventarium.service.AuthService
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "auth", description = "Authorisation in OpenID.")
@RequestMapping("/v1/auth")
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/login")
    fun login(
        @AuthenticationPrincipal jwt: Jwt
    ): UserDto {
        return authService.login(jwt.tokenValue)
    }

}