package com.cloudrader.inventarium.adapter.identityprovider

import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.dto.user.UserInfoOpenIdDto

interface IdentityProviderClient {
    suspend fun getIssuerInfo(configurationEndpoint: String): IdentityProviderIssuerInfoDto

    suspend fun decodeToken(token: String): Map<String, Any>

    suspend fun  getUserInfo(tenantAlias: String, token: String): UserInfoOpenIdDto

    suspend fun logout(refreshToken: String)
}
