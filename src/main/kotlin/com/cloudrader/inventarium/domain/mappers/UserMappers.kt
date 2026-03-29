package com.cloudrader.inventarium.domain.mappers

import com.cloudrader.inventarium.domain.dto.user.UserDto
import com.cloudrader.inventarium.domain.dto.user.UserInfoOpenIdDto
import com.cloudrader.inventarium.domain.model.User
import java.util.UUID

fun User.toDto(): UserDto {
    return UserDto(
        id = this.id,
        tenantId = this.tenantId,
        username = this.username,
        firstName = this.firstName,
        secondName = this.secondName,
        email = this.email,
        fullName = this.fullName,
    )
}

fun UserDto.toModel(tenantId: UUID): User {
    return User(
        id = this.id,
        tenantId = tenantId,
        username = this.username,
        firstName = this.firstName,
        secondName = this.secondName,
        email = this.email,
    )
}

fun UserInfoOpenIdDto.toModel(tenantId: UUID?): User {
    return User(
        id = this.sub,
        tenantId = tenantId!!,
        username = this.preferredUsername,
        firstName = this.givenName,
        secondName = this.givenName,
        email = this.email,
    )
}
