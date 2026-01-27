package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.openid.ImplOpenIdAuthService
import com.cloudrader.inventarium.adapter.repository.UserRepository
import com.cloudrader.inventarium.dto.UserDto
import com.cloudrader.inventarium.mappers.toDto
import com.cloudrader.inventarium.mappers.toModel
import com.cloudrader.inventarium.model.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val openIdAuthService: ImplOpenIdAuthService
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