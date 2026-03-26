package com.cloudrader.inventarium.infrastructure.repository.auditlog

import com.cloudrader.inventarium.domain.model.AuditLog
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface AuditLogRepository : CoroutineCrudRepository<AuditLog, UUID> {
    suspend fun findAllByTenantIdOrderByTimestampDesc(tenantId: UUID): Flow<AuditLog>

    suspend fun findAllByUserIdOrderByTimestampDesc(userId: String): Flow<AuditLog>
}
