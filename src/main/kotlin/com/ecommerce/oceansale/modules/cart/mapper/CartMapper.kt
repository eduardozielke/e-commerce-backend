package com.ecommerce.oceansale.modules.cart.mapper

import com.ecommerce.oceansale.modules.cart.dto.CartDTO
import com.ecommerce.oceansale.modules.cart.enitty.Cart
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface CartMapper {

    fun toDto(entity: Cart): CartDTO

    fun toEntity(dto: CartDTO): Cart

    fun toDto(entity: List<Cart>): List<CartDTO>

    fun toEntity(dto: List<CartDTO>): List<Cart>

    companion object {
        var INSTANCE : CartMapper = Mappers.getMapper(CartMapper::class.java)
    }
}