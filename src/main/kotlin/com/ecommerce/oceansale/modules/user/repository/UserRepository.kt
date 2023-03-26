package com.ecommerce.oceansale.modules.user.repository

import com.ecommerce.oceansale.modules.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun existsByEmail(email: String): Boolean
}