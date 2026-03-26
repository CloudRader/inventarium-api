package com.cloudrader.inventarium.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table(name = "audit_logs")
data class AuditLog(
    @Id val id: UUID? = null,

    @Column("tenant_id")
    val tenantId: UUID,
    @Column("user_id")
    val userId: String? = null,

    @Column("action")
    val action: String,
    @Column("entity_type")
    val entityType: String,
    @Column("entity_id")
    val entityId: UUID? = null,
    @Column("timestamp")
    val timestamp: Instant = Instant.now(),

    @Column("metadata")
    val metadata: String? = null,
)
