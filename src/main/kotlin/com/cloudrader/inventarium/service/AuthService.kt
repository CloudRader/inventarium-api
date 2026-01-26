package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.openid.ImplOpenIdAuthService
import com.cloudrader.inventarium.adapter.repository.UserRepository
import com.cloudrader.inventarium.model.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val openIdAuthService: ImplOpenIdAuthService
) {
    fun login (token: String): User {
        val userInfo = openIdAuthService.getUserInfo(token)

        val getUser = userRepository.findByIdOrNull(userInfo.sub)

        if (getUser != null) {
            return getUser
        }

        return userRepository.save(
            User(
                id = userInfo.sub,
                username = userInfo.preferredUsername,
                firstName = userInfo.givenName,
                secondName = userInfo.givenName,
                email = userInfo.email,
            )
        )
    }
}