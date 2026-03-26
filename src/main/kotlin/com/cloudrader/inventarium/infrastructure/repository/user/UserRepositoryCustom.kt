package com.cloudrader.inventarium.infrastructure.repository.user

import com.cloudrader.inventarium.domain.model.User

interface UserRepositoryCustom {
    suspend fun upsert(user: User): User
}
