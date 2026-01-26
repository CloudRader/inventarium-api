package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String> {
    fun findByEmail(email: String): User?
}