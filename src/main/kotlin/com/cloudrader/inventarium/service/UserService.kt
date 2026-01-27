package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.repository.UserRepository
import com.cloudrader.inventarium.dto.UserDto
import com.cloudrader.inventarium.mappers.toDto
import com.cloudrader.inventarium.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun getUser(id: String): UserDto {
        return userRepository.findById(id).get().toDto()
    }
}