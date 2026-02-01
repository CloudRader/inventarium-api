package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.PlatformAdmin
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PlatformAdminRepository: JpaRepository<PlatformAdmin, UUID> {
    fun findByUsername(username: String): PlatformAdmin?
}