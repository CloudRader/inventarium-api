package com.cloudrader.inventarium.adapter.openid

import com.cloudrader.inventarium.dto.user.UserInfoOpenIdDto

interface OpenIdAuthService {
    fun decodeToken(token: String): Map<String, Any>

    fun getUserInfo(token: String): UserInfoOpenIdDto

    fun logout(refreshToken: String)
}