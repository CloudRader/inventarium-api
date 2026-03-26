package com.cloudrader.inventarium.infrastructure.identityprovider

import com.cloudrader.inventarium.infrastructure.repository.identityprovider.IdentityProviderRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.config.logging.log
import com.cloudrader.inventarium.domain.dto.identityprovider.IdentityProviderIssuerInfoDto
import com.cloudrader.inventarium.domain.dto.user.UserInfoOpenIdDto
import kotlinx.coroutines.reactor.awaitSingle
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
        val identityProvider = identityProviderRepository.findByTenantAlias(tenantAlias)
            ?: run {
                log.warn("Tenant with alias={} not found", tenantAlias)
                throw NotFoundException("Tenant with alias '$tenantAlias' not found")
            }

        return webClient.get()
            .uri(identityProvider.userinfoEndpoint)
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
