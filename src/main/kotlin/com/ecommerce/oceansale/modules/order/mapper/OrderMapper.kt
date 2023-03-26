package com.ecommerce.oceansale.modules.order.mapper

import com.ecommerce.oceansale.modules.order.dto.OrderDTO
import com.ecommerce.oceansale.modules.order.entity.Order
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface OrderMapper {

    fun toDto(entity: Order): OrderDTO

    fun toEntity(dto: OrderDTO): Order

    fun toDto(entity: List<Order>): List<OrderDTO>

    fun toEntity(dto: List<OrderDTO>): List<Order>

    companion object {
        var INSTANCE : OrderMapper = Mappers.getMapper(OrderMapper::class.java)
    }
}