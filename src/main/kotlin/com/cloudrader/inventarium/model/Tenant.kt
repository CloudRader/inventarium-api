package com.cloudrader.inventarium.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import java.time.Instant
import java.util.UUID

@Table(name = "tenants")
data class Tenant(
    @Id val id: UUID? = null,
    @Column("name")
    val name: String,
    @Column("alias")
    val alias: String,
    @Column("created_at")
    val createdAt: Instant = Instant.now(),
    @Column("updated_at")
    val updatedAt: Instant? = null,
)
