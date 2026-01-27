package com.cloudrader.inventarium.mappers

import com.cloudrader.inventarium.dto.UserDto
import com.cloudrader.inventarium.dto.UserInfo
import com.cloudrader.inventarium.model.User

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

fun UserInfo.toModel(): User {
    return User(
        id = this.sub,
        username = this.preferredUsername,
        firstName = this.givenName,
        secondName = this.givenName,
        email = this.email,
    )
}