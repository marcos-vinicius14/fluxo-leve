package com.fluxodia.identityaccess.infrastructure.persistence

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object UserTable : Table("tb_user") {
    val id = uuid("id").autoIncrement()
    val username = varchar("username", 100)
    val email = varchar("email", 255).uniqueIndex()
    val password_hash = text("password_hash")
    val createdAt = datetime("created_at")

    override val primaryKey = PrimaryKey(id)
}