package com.cloudrader.inventarium.dto.user

import com.fasterxml.jackson.annotation.JsonProperty

data class UserInfoOpenIdDto(
    @JsonProperty("sub")
    val sub: String,
    @JsonProperty("preferred_username")
    val preferredUsername: String,
    @JsonProperty("given_name")
    val givenName: String,
//    @JsonProperty("family_name")
//    val familyName: String,
    @JsonProperty("email")
    val email: String
) {
//    val fullName: String
//        get() = "$givenName $familyName"
}
