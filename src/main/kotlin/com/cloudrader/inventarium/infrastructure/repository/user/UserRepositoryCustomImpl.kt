package com.cloudrader.inventarium.infrastructure.repository.user

import com.cloudrader.inventarium.domain.model.User
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.UUID

@Repository
class UserRepositoryCustomImpl(
    private val databaseClient: DatabaseClient
): UserRepositoryCustom {
    override suspend fun upsert(user: User): User {
        return databaseClient.sql(
            """
            INSERT INTO users (id, tenant_id, username, first_name, second_name, email, created_at)
            VALUES (:id, :tenantId, :username, :firstName, :secondName, :email, :createdAt)
            ON CONFLICT (id)
            DO UPDATE SET
                username = EXCLUDED.username,
                first_name = EXCLUDED.first_name,
                second_name = EXCLUDED.second_name,
                email = EXCLUDED.email
            RETURNING *
            """
        )
            .bind("id", user.id)
            .bind("tenantId", user.tenantId)
            .bind("username", user.username)
            .bind("firstName", user.firstName)
            .bind("secondName", user.secondName)
            .bind("email", user.email)
            .bind("createdAt", user.createdAt)
            .map { row, _ ->
                User(
                    id = row.get("id", String::class.java)!!,
                    tenantId = row.get("tenant_id", UUID::class.java)!!,
                    username = row.get("username", String::class.java)!!,
                    firstName = row.get("first_name", String::class.java)!!,
                    secondName = row.get("second_name", String::class.java)!!,
                    email = row.get("email", String::class.java)!!,
                    createdAt = row.get("created_at", Instant::class.java)!!,
                )
            }
            .one()
            .awaitSingle()
    }
}
