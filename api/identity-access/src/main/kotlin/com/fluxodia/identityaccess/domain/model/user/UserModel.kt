package com.fluxodia.identityaccess.domain.model.user

import com.fluxodia.core.exceptions.ValidationException
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
            throw ValidationException("O nome de usuário deve ser maior que 2 caracteres.")
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
                throw ValidationException("Formato de email inválido.")
            }
        }

        fun validatePassword(passwordHash: String) {
            if (passwordHash.length < 8) {
                throw ValidationException("A senha deve conter mais de 8 caracteres.")
            }
            if (!passwordHash.contains(Regex("[A-Z]"))) {
                throw ValidationException("Senha deve conter 1 letra maiuscula.")
            }
            if (!passwordHash.contains(Regex("[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]"))) {
                throw ValidationException("A senha deve conter 1 caractere especial.")
            }
        }


        fun create(name: String, email: String, passwordHash: String): User {
            if (name.isBlank() || email.isBlank()) {
                throw ValidationException("Nome e email são obrigatórios.")
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