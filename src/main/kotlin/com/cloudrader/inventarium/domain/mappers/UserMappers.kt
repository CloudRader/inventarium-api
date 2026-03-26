package com.cloudrader.inventarium.domain.mappers

import com.cloudrader.inventarium.domain.dto.user.UserDto
import com.cloudrader.inventarium.domain.dto.user.UserInfoOpenIdDto
import com.cloudrader.inventarium.domain.model.User

fun User.toDto(): UserDto {
    return UserDto(
        id = this.id,
        username = this.username,
        firstName = this.firstName,
        secondName = this.secondName,
        email = this.email,
        fullName = this.fullName,
    )
}

fun UserDto.toModel(): User {
    return User(
        id = this.id,
        username = this.username,
        firstName = this.firstName,
        secondName = this.secondName,
        email = this.email,
    )
}

fun UserInfoOpenIdDto.toModel(): User {
    return User(
        id = this.sub,
        username = this.preferredUsername,
        firstName = this.givenName,
        secondName = this.givenName,
        email = this.email,
    )
}
