package com.cloudrader.inventarium.adapter.identityprovider

import com.cloudrader.inventarium.adapter.repository.IdentityProviderRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.dto.user.UserInfoOpenIdDto
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class OpenIdConnectClient(
    private val webClient: WebClient,
    private val identityProviderRepository: IdentityProviderRepository,
): IdentityProviderClient {

    override fun getIssuerInfo(configurationEndpoint: String): IdentityProviderIssuerInfoDto {
        return webClient.get()
            .uri(configurationEndpoint)
            .retrieve()
            .bodyToMono<IdentityProviderIssuerInfoDto>()
            .block() ?: throw IllegalStateException("Bad gateway from IdP")
    }

    override fun decodeToken(token: String): Map<String, Any> {
        TODO("Not implemented yet")
    }

    override fun getUserInfo(tenantAlias: String, token: String): UserInfoOpenIdDto {
        val userInfoEndpoint = identityProviderRepository.findByAlias(tenantAlias)
            ?: throw NotFoundException("Tenant with alias '$tenantAlias' not found")

        return webClient.get()
            .uri(userInfoEndpoint.userinfoEndpoint)
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
