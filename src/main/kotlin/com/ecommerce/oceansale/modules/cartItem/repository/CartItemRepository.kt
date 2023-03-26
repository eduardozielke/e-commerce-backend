package com.ecommerce.oceansale.modules.cartItem.repository

import com.ecommerce.oceansale.modules.cartItem.entity.CartItem
import com.ecommerce.oceansale.modules.creditCard.entity.CreditCard
import org.springframework.data.jpa.repository.JpaRepository

interface CartItemRepository : JpaRepository<CartItem, Long> {
}