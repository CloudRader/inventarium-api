package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.repository.TenantRepository
import com.cloudrader.inventarium.config.exception.ConflictException
import com.cloudrader.inventarium.dto.TenantCreateDto
import com.cloudrader.inventarium.dto.TenantDto
import com.cloudrader.inventarium.mappers.toDto
import com.cloudrader.inventarium.mappers.toModel
import org.springframework.stereotype.Service

@Service
class TenantService(
    private val tenantRepository: TenantRepository
) {
    fun createTenant(tenantCreate: TenantCreateDto): TenantDto {
        val tenantByAlias = tenantRepository.findByAlias(tenantCreate.alias)
        
        if (tenantByAlias != null) {
            val alias = tenantCreate.alias
            throw ConflictException("Tenant with alias=$alias already exist")
        }

        return tenantRepository.save(tenantCreate.toModel()).toDto()
    }
}