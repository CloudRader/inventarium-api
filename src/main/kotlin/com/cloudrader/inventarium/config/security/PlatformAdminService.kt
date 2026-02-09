package com.cloudrader.inventarium.config.security

import com.cloudrader.inventarium.adapter.repository.PlatformAdminRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class PlatformAdminService(
    private val platformAdminRepository: PlatformAdminRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val admin = platformAdminRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("Admin not found")
        return PlatformAdminSecurity(admin)
    }
}
