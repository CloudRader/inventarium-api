package com.cloudrader.inventarium.infrastructure.repository.identityprovider

import com.cloudrader.inventarium.domain.model.IdentityProvider
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface IdentityProviderRepository: CoroutineCrudRepository<IdentityProvider, UUID> {
    suspend fun findByAlias(alias: String): IdentityProvider?

    @Query("""
        SELECT idp.*
        FROM identity_providers idp
        JOIN tenants t ON idp.tenant_id = t.id
        WHERE t.alias = :tenantAlias
        LIMIT 1
    """)
    suspend fun findByTenantAlias(tenantAlias: String): IdentityProvider?
}
