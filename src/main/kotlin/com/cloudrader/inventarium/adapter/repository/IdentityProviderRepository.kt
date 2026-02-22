package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.IdentityProvider
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface IdentityProviderRepository: ReactiveCrudRepository<IdentityProvider, UUID> {
    fun findByAlias(alias: String): Mono<IdentityProvider>
}
