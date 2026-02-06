package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.dto.user.UserDto
import com.cloudrader.inventarium.service.AuthService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Auth", description = "Authorisation in OpenID.")
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