package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.Tenant
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface TenantRepository: ReactiveCrudRepository<Tenant, UUID> {
    fun findByAlias(alias: String): Mono<Tenant>
}
