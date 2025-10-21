package com.fluxodia.identityaccess.domain.model.user

import java.time.ZonedDateTime
import java.util.UUID

data class User(
    val id: UUID,
    var name: String,
    val email: String,
    private var passwordHash: String,
    val createdAt: ZonedDateTime
) {

    fun changeName(newName: String) {
        if (newName.isBlank() || newName.length < 2) {
            throw IllegalArgumentException("User name must be at least 2 characters long.")
        }
        this.copy(name = newName)
    }

    fun verifyPassword(providedPasswordHash: String): Boolean {
        return this.passwordHash == providedPasswordHash
    }


    companion object {
        private val EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()

        fun validateEmail(email: String) {
            if (!EMAIL_REGEX.matches(email)) {
                throw IllegalArgumentException("Invalid email format.")
            }
        }

        fun validatePassword(passwordHash: String) {
            if (passwordHash.length < 8) {
                throw IllegalArgumentException("Password must be at least 8 characters long.")
            }
            if (!passwordHash.contains(Regex("[A-Z]"))) {
                throw IllegalArgumentException("Password must contain at least one uppercase letter.")
            }
            if (!passwordHash.contains(Regex("[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]"))) {
                throw IllegalArgumentException("Password must contain at least one special character.")
            }
        }


        fun create(name: String, email: String, passwordHash: String): User {
            if (name.isBlank() || email.isBlank()) {
                throw IllegalArgumentException("Name and email are required.")
            }

            return User(
                id = UUID.randomUUID(),
                name = name,
                email = email,
                passwordHash = passwordHash,
                createdAt = ZonedDateTime.now()
            )
        }
    }
}