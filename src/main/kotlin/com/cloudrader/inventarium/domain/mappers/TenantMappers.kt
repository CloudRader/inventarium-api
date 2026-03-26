package com.cloudrader.inventarium.domain.mappers

import com.cloudrader.inventarium.domain.dto.tenant.TenantCreateDto
import com.cloudrader.inventarium.domain.dto.tenant.TenantDto
import com.cloudrader.inventarium.domain.dto.tenant.TenantUpdateDto
import com.cloudrader.inventarium.domain.model.Tenant
import java.time.Instant

fun Tenant.toDto(): TenantDto {
    return TenantDto(
        id = requireNotNull(this.id),
        name = this.name,
        alias = this.alias,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
    )
}

fun TenantCreateDto.toModel(): Tenant {
    return Tenant(
        name = this.name,
        alias = this.alias,
    )
}

fun Tenant.updateFrom(dto: TenantUpdateDto): Tenant {
    return this.copy(
        name = dto.name,
        alias = dto.alias,
        updatedAt = Instant.now()
    )
}
