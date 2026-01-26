package com.cloudrader.inventarium.dto

data class OpenIdConfiguration(
    val issuer: String,
    val authorizationEndpoint: String,
    val tokenEndpoint: String,
    val userInfoEndpoint: String,
    val jwksUri: String,
)
