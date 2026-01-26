package com.cloudrader.inventarium.adapter.openid

import com.cloudrader.inventarium.dto.UserInfo
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class ImplOpenIdAuthService(
    private val webClient: WebClient
): OpenIdAuthService {

    override fun decodeToken(token: String): Map<String, Any> {
        TODO("Not implemented yet")
    }

    override fun getUserInfo(token: String): UserInfo {
        return webClient.get()
            .uri("http://localhost:9000/application/o/userinfo/")
            .headers { headers ->
                headers.setBearerAuth(token)
            }
            .retrieve()
            .bodyToMono<UserInfo>()
            .block() ?: throw IllegalStateException("Empty responce from IdP")
    }

    override fun logout(refreshToken: String) {
        TODO("Not implemented yet")
    }
}