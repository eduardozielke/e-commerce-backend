package com.ecommerce.oceansale.modules.cartItem.mapper

import com.ecommerce.oceansale.modules.creditCard.dto.CreditCardDTO
import com.ecommerce.oceansale.modules.creditCard.entity.CreditCard
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface CreditCardMapper {

    fun toDto(entity: CreditCard): CreditCardDTO

    fun toEntity(dto: CreditCardDTO): CreditCard

    fun toDto(entity: List<CreditCard>): List<CreditCardDTO>

    fun toEntity(dto: List<CreditCardDTO>): List<CreditCard>

    companion object {
        var INSTANCE : CreditCardMapper = Mappers.getMapper(CreditCardMapper::class.java)
    }
}