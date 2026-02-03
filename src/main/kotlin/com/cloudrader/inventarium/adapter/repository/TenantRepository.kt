package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.Tenant
import org.springframework.data.jpa.repository.JpaRepository

interface TenantRepository: JpaRepository<Tenant, Long> {
    fun findByAlias(alias: String): Tenant?
}