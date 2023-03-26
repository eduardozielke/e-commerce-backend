package com.ecommerce.oceansale.modules.orderItem.repository

import com.ecommerce.oceansale.modules.orderItem.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Long> {
}