package com.fluxodia.core.infraestructure

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {
    fun init(config: ApplicationConfig) {
        val driverClassName = config.property("database.driverClassName").getString()
        val jdbcUrl = config.property("database.jdbcUrl").getString()
        val user = config.property("database.user").getString()
        val password = config.property("database.password").getString()

        val hikariDataSource = createHikariDataSource(
            url = jdbcUrl,
            user = user,
            password = password,
            driver = driverClassName
        )

        val flyway = Flyway.configure().dataSource(hikariDataSource).load()
        flyway.migrate()

        Database.connect(hikariDataSource)
    }

    private fun createHikariDataSource(
        url: String,
        user: String,
        password: String,
        driver: String
    ): HikariDataSource {
        val hikariConfig = HikariConfig().apply {
            driverClassName = driver
            jdbcUrl = url
            username = user
            this.password = password
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(hikariConfig)
    }
}