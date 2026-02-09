package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.Tenant
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TenantRepository: JpaRepository<Tenant, UUID> {
    fun findByAlias(alias: String): Tenant?
}
