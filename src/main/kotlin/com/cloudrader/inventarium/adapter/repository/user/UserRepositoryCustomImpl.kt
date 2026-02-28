package com.cloudrader.inventarium.adapter.repository.user

import com.cloudrader.inventarium.model.User
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryCustomImpl(
    private val databaseClient: DatabaseClient
): UserRepositoryCustom {
    override suspend fun upsert(user: User): User {
        return databaseClient.sql(
            """
            INSERT INTO users (id, username, first_name, second_name, email)
            VALUES (:id, :username, :firstName, :secondName, :email)
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
            .bind("username", user.username)
            .bind("firstName", user.firstName)
            .bind("secondName", user.secondName)
            .bind("email", user.email)
            .map { row, _ ->
                User(
                    id = row.get("id", String::class.java)!!,
                    username = row.get("username", String::class.java)!!,
                    firstName = row.get("first_name", String::class.java)!!,
                    secondName = row.get("second_name", String::class.java)!!,
                    email = row.get("email", String::class.java)!!
                )
            }
            .one()
            .awaitSingle()
    }
}
