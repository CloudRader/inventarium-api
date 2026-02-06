package com.cloudrader.inventarium.mappers

import com.cloudrader.inventarium.dto.tenant.TenantCreateDto
import com.cloudrader.inventarium.dto.tenant.TenantDto
import com.cloudrader.inventarium.model.Tenant

fun Tenant.toDto(): TenantDto {
    return TenantDto(
        id = this.id,
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
