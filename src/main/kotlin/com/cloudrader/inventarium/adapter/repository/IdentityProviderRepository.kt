package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.IdentityProvider
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface IdentityProviderRepository: JpaRepository<IdentityProvider, UUID> {
    fun findByAlias(alias: String): IdentityProvider?
}