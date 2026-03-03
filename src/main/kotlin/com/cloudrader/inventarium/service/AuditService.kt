package com.cloudrader.inventarium.service

import com.cloudrader.inventarium.adapter.repository.auditlog.AuditLogRepository
import com.cloudrader.inventarium.model.AuditLog
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class AuditService(
    private val auditLogRepository: AuditLogRepository
) {
    suspend fun log(
        tenantId: UUID,
        userId: String? = null,
        action: String,
        entityType: String? = null,
        entityId: UUID? = null,
        metadata: String? = null
    ): AuditLog {
        val audit = AuditLog(
            tenantId = tenantId,
            userId = userId,
            action = action,
            entityType = entityType ?: "UNKNOWN",
            entityId = entityId,
            metadata = metadata,
            timestamp = Instant.now()
        )

        return auditLogRepository.save(audit)
    }

    suspend fun getLogsForTenant(tenantId: UUID): Flow<AuditLog> {
        return auditLogRepository.findAllByTenantIdOrderByTimestampDesc(tenantId)
    }

    suspend fun getLogsForUser(userId: String): Flow<AuditLog> {
        return auditLogRepository.findAllByUserIdOrderByTimestampDesc(userId)
    }
}
