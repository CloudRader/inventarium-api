package com.cloudrader.inventarium.adapter.identityprovider

import com.cloudrader.inventarium.adapter.repository.IdentityProviderRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.dto.user.UserInfoOpenIdDto
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Service
class OpenIdConnectClient(
    private val webClient: WebClient,
    private val identityProviderRepository: IdentityProviderRepository,
): IdentityProviderClient {

    override suspend fun getIssuerInfo(
        configurationEndpoint: String
    ): IdentityProviderIssuerInfoDto {

        return webClient.get()
            .uri(configurationEndpoint)
            .retrieve()
            .onStatus({ it.isError }) {
                Mono.error(IllegalStateException("Bad gateway from IdP"))
            }
            .bodyToMono<IdentityProviderIssuerInfoDto>()
            .awaitSingle()
    }

    override suspend fun decodeToken(token: String): Map<String, Any> {
        TODO("Not implemented yet")
    }

    override suspend fun getUserInfo(tenantAlias: String, token: String): UserInfoOpenIdDto {
        val userInfoEndpoint = identityProviderRepository.findByAlias(tenantAlias)
            .awaitSingleOrNull() ?: throw NotFoundException("Tenant with alias '$tenantAlias' not found")

        return webClient.get()
            .uri(userInfoEndpoint.userinfoEndpoint)
            .headers { headers ->
                headers.setBearerAuth(token)
            }
            .retrieve()
            .onStatus({ it.isError }) {
                Mono.error(IllegalStateException("Empty response from IdP"))
            }
            .bodyToMono<UserInfoOpenIdDto>()
            .awaitSingle()
    }

    override suspend fun logout(refreshToken: String) {
        TODO("Not implemented yet")
    }
}
