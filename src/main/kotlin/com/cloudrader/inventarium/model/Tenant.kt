package com.cloudrader.inventarium.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "tenants")
class Tenant(
    @Id val id: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val name: String = "",
    @Column(unique = true, nullable = false)
    val alias: String = "",
    @Column
    val createdAt: Instant = Instant.now(),
    @Column
    val updatedAt: Instant? = null,
)