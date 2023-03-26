package com.ecommerce.oceansale.modules.cartItem.mapper

import com.ecommerce.oceansale.modules.cartItem.dto.CartItemDTO
import com.ecommerce.oceansale.modules.cartItem.entity.CartItem
import com.ecommerce.oceansale.modules.creditCard.dto.CreditCardDTO
import com.ecommerce.oceansale.modules.creditCard.entity.CreditCard
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface CartItemMapper {

    fun toDto(entity: CartItem): CartItemDTO

    fun toEntity(dto: CartItemDTO): CartItem

    fun toDto(entity: List<CartItem>): List<CartItemDTO>

    fun toEntity(dto: List<CartItemDTO>): List<CartItem>

    companion object {
        var INSTANCE : CartItemMapper = Mappers.getMapper(CartItemMapper::class.java)
    }
}