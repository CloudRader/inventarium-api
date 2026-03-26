package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.infrastructure.identityprovider.OpenIdConnectClient
import com.cloudrader.inventarium.infrastructure.repository.user.UserRepository
import com.cloudrader.inventarium.domain.dto.user.UserDto
import com.cloudrader.inventarium.domain.mappers.toDto
import com.cloudrader.inventarium.domain.mappers.toModel
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val openIdAuthService: OpenIdConnectClient,
) {
    suspend fun login (tenantAlias: String, token: String): UserDto {
        val userInfo = openIdAuthService.getUserInfo(tenantAlias, token)

        val getUser = userRepository.findById(userInfo.sub)

        if (getUser != null) {
            return getUser.toDto()
        }

        return userRepository.upsert(userInfo.toModel()).toDto()
    }
}
