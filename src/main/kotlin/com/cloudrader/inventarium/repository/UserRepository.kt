package com.cloudrader.inventarium.repository

import com.cloudrader.inventarium.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {
    fun findByEmail(email: String): User?
}