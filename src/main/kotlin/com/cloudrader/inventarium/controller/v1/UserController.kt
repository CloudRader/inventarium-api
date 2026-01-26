package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.model.User
import com.cloudrader.inventarium.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "users", description = "Operations with users.")
@RequestMapping("/v1/users")
class UserController(
    private val userService: UserService,
) {
    @GetMapping(path = ["/me"])
    fun getUser(@AuthenticationPrincipal jwt: Jwt): User {
        return userService.getUser(jwt.claims["sub"].toString())
    }
}