package com.cloudrader.inventarium.dto

import java.util.UUID
import java.time.Instant

data class TenantCreateDto(
    val name: String,
    val alias: String,
)

data class TenantDto(
    val id: UUID,
    val name: String,
    val alias: String,
    val createdAt: Instant,
    val updatedAt: Instant?,
)
