package com.cloudrader.inventarium.adapter.identityprovider

import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.dto.user.UserInfoOpenIdDto
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class OpenIdConnectClient(
    private val webClient: WebClient
): IdentityProviderClient {

    override fun getIssuerInfo(issuerUrl: String): IdentityProviderIssuerInfoDto {
        return webClient.get()
            .uri(issuerUrl)
            .retrieve()
            .bodyToMono<IdentityProviderIssuerInfoDto>()
            .block() ?: throw IllegalStateException("Bad gateway from IdP")
    }

    override fun decodeToken(token: String): Map<String, Any> {
        TODO("Not implemented yet")
    }

    override fun getUserInfo(token: String): UserInfoOpenIdDto {
        return webClient.get()
            .uri("http://localhost:9000/application/o/userinfo/")
            .headers { headers ->
                headers.setBearerAuth(token)
            }
            .retrieve()
            .bodyToMono<UserInfoOpenIdDto>()
            .block() ?: throw IllegalStateException("Empty response from IdP")
    }

    override fun logout(refreshToken: String) {
        TODO("Not implemented yet")
    }
}