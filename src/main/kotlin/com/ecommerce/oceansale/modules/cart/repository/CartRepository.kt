package com.ecommerce.oceansale.modules.cart.repository

import com.ecommerce.oceansale.modules.cart.enitty.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository<Cart, Long> {
}