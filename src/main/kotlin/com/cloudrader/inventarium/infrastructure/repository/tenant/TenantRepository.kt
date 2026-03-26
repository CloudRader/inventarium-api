package com.cloudrader.inventarium.infrastructure.repository.tenant

import com.cloudrader.inventarium.domain.model.Tenant
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface TenantRepository: CoroutineCrudRepository<Tenant, UUID> {
    suspend fun findByAlias(alias: String): Tenant?
}
