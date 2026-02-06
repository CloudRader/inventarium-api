package com.cloudrader.inventarium.controller.v1

import com.cloudrader.inventarium.controller.responces.AuthenticatedAccount
import com.cloudrader.inventarium.dto.user.UserDto
import com.cloudrader.inventarium.service.UserService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Users", description = "Operations with users.")
@RequestMapping("/v1/users")
@AuthenticatedAccount
class UserController(
    private val userService: UserService,
) {
    @GetMapping(path = ["/me"])
    @ResponseStatus(HttpStatus.OK)
    fun getMe(@AuthenticationPrincipal jwt: Jwt): ResponseEntity<UserDto> {
        return ResponseEntity.ok(userService.getUser(jwt.claims["sub"].toString()))
    }
}