package com.cloudrader.inventarium.infrastructure.repository.user

import com.cloudrader.inventarium.domain.model.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository:
    CoroutineCrudRepository<User, String>,
    UserRepositoryCustom
{
    suspend fun findByEmail(email: String): User?
}
