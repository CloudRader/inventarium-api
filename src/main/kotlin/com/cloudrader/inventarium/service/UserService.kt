package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.infrastructure.repository.user.UserRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.config.logging.log
import com.cloudrader.inventarium.domain.dto.user.UserDto
import com.cloudrader.inventarium.domain.mappers.toDto
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    suspend fun getMe(id: String): UserDto {
        log.info("Fetching user with id={}", id)

        val user = userRepository.findById(id)
            ?: run {
                log.warn("User with id={} not found", id)
                throw NotFoundException("User with id=$id not found")
            }

        log.debug("User with id={} found successfully", id)
        return user.toDto()
    }
}
