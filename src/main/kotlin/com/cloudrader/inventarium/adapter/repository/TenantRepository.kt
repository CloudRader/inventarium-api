package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.Tenant
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface TenantRepository: CoroutineCrudRepository<Tenant, UUID> {
    suspend fun findByAlias(alias: String): Tenant?
}
