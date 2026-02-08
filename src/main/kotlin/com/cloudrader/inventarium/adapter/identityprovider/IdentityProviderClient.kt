package com.cloudrader.inventarium.adapter.identityprovider

import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.dto.user.UserInfoOpenIdDto

interface IdentityProviderClient {
    fun getIssuerInfo(configurationEndpoint: String): IdentityProviderIssuerInfoDto

    fun decodeToken(token: String): Map<String, Any>

    fun getUserInfo(tenantAlias: String, token: String): UserInfoOpenIdDto

    fun logout(refreshToken: String)
}