package com.cloudrader.inventarium.domain.dto.user

import java.util.UUID

data class UserDto(
    val id: String,
    val tenantId: UUID,
    val username: String,
    val firstName: String,
    val secondName: String,
    val email: String,
    val fullName: String,
)
