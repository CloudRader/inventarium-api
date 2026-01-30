package com.cloudrader.inventarium.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "platform_admins")
class PlatformAdmin(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(nullable = false, unique = true)
    val username: String = "",
    @Column(nullable = false)
    val passwordHash: String = "",
)