package com.cloudrader.inventarium.config.security

import com.cloudrader.inventarium.model.PlatformAdmin
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class PlatformAdminSecurity(
    private val admin: PlatformAdmin
) : UserDetails {

    override fun getUsername() = admin.username
    override fun getPassword() = admin.passwordHash

    override fun getAuthorities() =
        listOf(SimpleGrantedAuthority("ROLE_PLATFORM_ADMIN"))

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}
