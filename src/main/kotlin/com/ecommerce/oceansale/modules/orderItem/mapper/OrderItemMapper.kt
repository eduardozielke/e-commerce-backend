package com.ecommerce.oceansale.modules.orderItem.mapper

import com.ecommerce.oceansale.modules.orderItem.dto.OrderItemDTO
import com.ecommerce.oceansale.modules.orderItem.entity.OrderItem
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
interface OrderItemMapper {

    fun toDto(entity: OrderItem): OrderItemDTO

    fun toEntity(dto: OrderItemDTO): OrderItem

    fun toDto(entity: List<OrderItem>): List<OrderItemDTO>

    fun toEntity(dto: List<OrderItemDTO>): List<OrderItem>

    companion object {
        var INSTANCE : OrderItemMapper = Mappers.getMapper(OrderItemMapper::class.java)
    }
}