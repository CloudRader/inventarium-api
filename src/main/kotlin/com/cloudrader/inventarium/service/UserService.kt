package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.repository.UserRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.config.logging.log
import com.cloudrader.inventarium.dto.user.UserDto
import com.cloudrader.inventarium.mappers.toDto
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun getUser(id: String): UserDto {
        log.info("Fetching user with id={}", id)

        val user = userRepository.findById(id)
            .orElseThrow {
                log.warn("User with id={} not found", id)
                NotFoundException("User with id=$id not found")
            }

        log.debug("User with id={} found successfully", id)
        return user.toDto()
    }
}
