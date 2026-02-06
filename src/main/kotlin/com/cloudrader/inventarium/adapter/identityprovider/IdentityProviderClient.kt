package com.cloudrader.inventarium.adapter.identityprovider

import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.dto.user.UserInfoOpenIdDto

interface IdentityProviderClient {
    fun getIssuerInfo(issuerUrl: String): IdentityProviderIssuerInfoDto

    fun decodeToken(token: String): Map<String, Any>

    fun getUserInfo(token: String): UserInfoOpenIdDto

    fun logout(refreshToken: String)
}