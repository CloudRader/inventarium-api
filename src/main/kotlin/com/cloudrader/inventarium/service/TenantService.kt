package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.repository.TenantRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.config.logging.log
import com.cloudrader.inventarium.dto.tenant.TenantCreateDto
import com.cloudrader.inventarium.dto.tenant.TenantDto
import com.cloudrader.inventarium.mappers.toDto
import com.cloudrader.inventarium.mappers.toModel
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TenantService(
    private val tenantRepository: TenantRepository
) {
    fun create(tenantCreate: TenantCreateDto): TenantDto {
        return tenantRepository.save(tenantCreate.toModel()).toDto()
    }

    fun get(id: UUID): TenantDto {
        val tenant = tenantRepository.findById(id).orElseThrow {
            log.warn("User with id={} not found", id)
            NotFoundException("Tenant with id=$id not found")
        }

        log.debug("User with id={} found successfully", id)
        return tenant.toDto()
    }
}
