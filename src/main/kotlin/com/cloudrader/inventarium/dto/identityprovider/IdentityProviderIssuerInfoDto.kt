package com.cloudrader.inventarium.dto.identityprovider

import com.fasterxml.jackson.annotation.JsonProperty

data class IdentityProviderIssuerInfoDto(
    @JsonProperty("issuer")
    val issuer: String,
    @JsonProperty("authorization_endpoint")
    val authorizationEndpoint: String,
    @JsonProperty("token_endpoint")
    val tokenEndpoint: String,
    @JsonProperty("userinfo_endpoint")
    val userinfoEndpoint: String,
    @JsonProperty("end_session_endpoint")
    val endSessionEndpoint: String,
    @JsonProperty("jwks_uri")
    val jwksUri: String,
    @JsonProperty("scopes_supported")
    val scopesSupported: List<String>,
)
