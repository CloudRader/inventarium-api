package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository: CoroutineCrudRepository<User, String> {
    suspend fun findByEmail(email: String): User?
}
