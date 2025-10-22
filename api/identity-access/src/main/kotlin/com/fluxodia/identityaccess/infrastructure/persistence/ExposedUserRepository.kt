package com.fluxodia.identityaccess.infrastructure.persistence

import com.fluxodia.identityaccess.domain.model.user.User
import com.fluxodia.identityaccess.domain.repository.UserRepository
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

class ExposedUserRepository : UserRepository {
    private fun toUser(row: ResultRow): User = User(
        id = row[UserTable.id],
        name = row[UserTable.username],
        email = row[UserTable.email],
        passwordHash = row[UserTable.password_hash],
        createdAt = row[UserTable.createdAt]
    )

    override fun save(user: User) {
        transaction {
            UserTable.insert {
                it[id] = user.id
                it[username] = user.name
                it[email] = user.email
                it[password_hash] = user.passwordHash
                it[createdAt] = user.createdAt
            }
        }
    }

    override fun findById(id: UUID): User? {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): User? {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }
}