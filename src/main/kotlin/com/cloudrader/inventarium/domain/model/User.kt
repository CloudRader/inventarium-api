package com.cloudrader.inventarium.domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import java.time.Instant
import java.util.UUID


@Table(name = "users")
data class User(
    @Id val id: String,
    @Column("tenant_id")
    val tenantId: UUID,
    @Column("username")
    val username: String,
    @Column("first_name")
    val firstName: String,
    @Column("second_name")
    val secondName: String,
    @Column("email")
    val email: String,
    @Column("created_at")
    val createdAt: Instant = Instant.now(),
) {
    val fullName: String
        get() = "$firstName $secondName"
}
