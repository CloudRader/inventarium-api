package com.cloudrader.inventarium.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.relational.core.mapping.Column
import java.util.UUID

@Table(name = "identity_providers")
data class IdentityProvider(
    @Id val id: UUID? = null,

    @Column("tenant_id")
    val tenantId: UUID,

    @Column("type")
    var type: String,
    @Column("name")
    var name: String,
    @Column("alias")
    var alias: String,

    @Column("client_id")
    val clientId: String,
    @Column("client_secret_hashed")
    val clientSecretHashed: String,

    @Column("configuration_endpoint")
    val configurationEndpoint: String,
    @Column("issuer")
    val issuer: String,
    @Column("authorization_endpoint")
    val authorizationEndpoint: String,
    @Column("token_endpoint")
    val tokenEndpoint: String,
    @Column("userinfo_endpoint")
    val userinfoEndpoint: String,
    @Column("end_session_endpoint")
    val endSessionEndpoint: String,
    @Column("jwks_uri")
    val jwksUri: String,
    @Column("scopes_supported")
    val scopesSupported: String,

    @Column("enabled")
    val enabled: Boolean = true,

    @Column("primary_provider")
    val primaryProvider: Boolean = false,
)
