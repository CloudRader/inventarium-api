package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.repository.tenant.TenantRepository
import com.cloudrader.inventarium.config.exception.NotFoundException
import com.cloudrader.inventarium.config.logging.log
import com.cloudrader.inventarium.dto.tenant.TenantCreateDto
import com.cloudrader.inventarium.dto.tenant.TenantDto
import com.cloudrader.inventarium.dto.tenant.TenantUpdateDto
import com.cloudrader.inventarium.mappers.toDto
import com.cloudrader.inventarium.mappers.toModel
import com.cloudrader.inventarium.mappers.updateFrom
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TenantService(
    private val tenantRepository: TenantRepository
) {
    suspend fun create(tenantCreate: TenantCreateDto): TenantDto {
        return tenantRepository.save(tenantCreate.toModel()).toDto()
    }

    suspend fun getALl(): List<TenantDto> {
        return tenantRepository.findAll()
            .toList()
            .map { it.toDto() }
    }

    suspend fun get(id: UUID): TenantDto {
        val tenant = tenantRepository.findById(id)
            ?: run {
                log.warn("User with id={} not found", id)
                throw NotFoundException("Tenant with id=$id not found")
            }

        log.debug("User with id={} found successfully", id)
        return tenant.toDto()
    }

    suspend fun getByAlias(alias: String): TenantDto {
        val tenant = tenantRepository.findByAlias(alias)
            ?: run {
                log.warn("User with alias={} not found", alias)
                throw NotFoundException("Tenant with alias=$alias not found")
            }

        log.debug("User with alias={} found successfully", alias)
        return tenant.toDto()
    }

    suspend fun update(id: UUID, updateDto: TenantUpdateDto): TenantDto {
        val existingTenant = tenantRepository.findById(id)
            ?: run {
                log.warn("Tenant with id={} not found", id)
                throw NotFoundException("Tenant with id=$id not found")
            }

        val updatedTenant = existingTenant.updateFrom(updateDto)

        return tenantRepository.save(updatedTenant).toDto()
    }

    suspend fun delete(id: UUID) {
        get(id)
        tenantRepository.deleteById(id)
    }
}
