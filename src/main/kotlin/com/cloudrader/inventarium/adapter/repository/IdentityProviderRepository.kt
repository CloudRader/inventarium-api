package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.IdentityProvider
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface IdentityProviderRepository: CoroutineCrudRepository<IdentityProvider, UUID> {
    suspend fun findByAlias(alias: String): IdentityProvider?
}
