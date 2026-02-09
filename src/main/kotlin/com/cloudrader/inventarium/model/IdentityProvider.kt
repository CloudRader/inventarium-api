package com.cloudrader.inventarium.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "identity_providers")
class IdentityProvider(
    @Id val id: UUID = UUID.randomUUID(),

    @Column(name = "tenant_id", nullable = false)
    val tenantId: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    var type: String = "",
    @Column(nullable = false)
    var name: String = "",
    @Column(nullable = false)
    var alias: String = "",

    @Column(nullable = false, unique = true)
    val clientId: String = "",
    @Column(nullable = false)
    val clientSecretHashed: String = "",

    @Column(nullable = false)
    val configurationEndpoint: String = "",
    @Column(nullable = false)
    val issuer: String = "",
    @Column(nullable = false)
    val authorizationEndpoint: String = "",
    @Column(nullable = false)
    val tokenEndpoint: String = "",
    @Column(nullable = false)
    val userinfoEndpoint: String = "",
    @Column(nullable = false)
    val endSessionEndpoint: String = "",
    @Column(nullable = false)
    val jwksUri: String = "",
    @Column(nullable = false)
    val scopesSupported: String = "",

    @Column(nullable = false)
    val enabled: Boolean = true,
)
