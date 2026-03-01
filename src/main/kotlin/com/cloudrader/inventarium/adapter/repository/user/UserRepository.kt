package com.cloudrader.inventarium.adapter.repository.user

import com.cloudrader.inventarium.model.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository:
    CoroutineCrudRepository<User, String>,
    UserRepositoryCustom
{
    suspend fun findByEmail(email: String): User?
}
