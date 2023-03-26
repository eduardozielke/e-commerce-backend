package com.ecommerce.oceansale.modules.order.dto

import com.ecommerce.oceansale.enums.OrderStatus
import com.ecommerce.oceansale.modules.order.entity.Order
import com.ecommerce.oceansale.modules.orderItem.dto.OrderItemDTO
import com.ecommerce.oceansale.modules.orderItem.entity.OrderItem
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

class OrderDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null
    var orderItems: List<OrderItemDTO>? = null
    var total: Long? = null
    var status: OrderStatus? = null
}
