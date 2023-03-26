package com.ecommerce.oceansale.modules.order.repository

import com.ecommerce.oceansale.modules.order.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
}