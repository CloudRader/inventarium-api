package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.identityprovider.OpenIdConnectClient
import com.cloudrader.inventarium.adapter.repository.UserRepository
import com.cloudrader.inventarium.dto.user.UserDto
import com.cloudrader.inventarium.mappers.toDto
import com.cloudrader.inventarium.mappers.toModel
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val openIdAuthService: OpenIdConnectClient
) {
    fun login (token: String): UserDto {
        val userInfo = openIdAuthService.getUserInfo(token)

        val getUser = userRepository.findByIdOrNull(userInfo.sub)

        if (getUser != null) {
            return getUser.toDto()
        }

        return userRepository.save(userInfo.toModel()).toDto()
    }
}