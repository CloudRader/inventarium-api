package com.cloudrader.inventarium.adapter.repository.user

import com.cloudrader.inventarium.model.User

interface UserRepositoryCustom {
    suspend fun upsert(user: User): User
}
