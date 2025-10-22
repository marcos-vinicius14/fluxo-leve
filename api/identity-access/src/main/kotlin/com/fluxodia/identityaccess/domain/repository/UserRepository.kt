package com.fluxodia.identityaccess.domain.repository

import com.fluxodia.identityaccess.domain.model.user.User
import java.util.UUID

interface UserRepository {
    fun save(user: User)
    fun findById(id: UUID): User?
    fun findByEmail(email: String): User?
    fun delete(id: UUID)
}