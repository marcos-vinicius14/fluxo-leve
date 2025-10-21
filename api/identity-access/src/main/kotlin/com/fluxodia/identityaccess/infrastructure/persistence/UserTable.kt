package com.fluxodia.identityaccess.infrastructure.persistence

import org.jetbrains.exposed.sql.Table

object UserTable : Table("tb_user") {
    val id = integer("id").autoIncrement()
}