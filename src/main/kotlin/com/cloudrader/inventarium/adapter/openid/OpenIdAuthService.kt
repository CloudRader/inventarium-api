package com.cloudrader.inventarium.adapter.openid

import com.cloudrader.inventarium.dto.UserInfo

interface OpenIdAuthService {
    fun decodeToken(token: String): Map<String, Any>

    fun getUserInfo(token: String): UserInfo

    fun logout(refreshToken: String)
}