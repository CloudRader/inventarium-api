package com.cloudrader.inventarium.adapter.repository

import com.cloudrader.inventarium.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface UserRepository: ReactiveCrudRepository<User, String> {
    fun findByEmail(email: String): Mono<User>
}
