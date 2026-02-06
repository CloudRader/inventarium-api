package com.cloudrader.inventarium.dto.tenant

import java.time.Instant
import java.util.UUID

data class TenantDto(
    val id: UUID,
    val name: String,
    val alias: String,
    val createdAt: Instant,
    val updatedAt: Instant?,
)