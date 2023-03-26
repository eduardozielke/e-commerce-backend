package com.ecommerce.oceansale.modules.cartItem.service

import com.ecommerce.oceansale.modules.cartItem.dto.CartItemDTO
import com.ecommerce.oceansale.modules.cartItem.mapper.CartItemMapper
import com.ecommerce.oceansale.modules.creditCard.dto.CreditCardDTO
import com.ecommerce.oceansale.modules.cartItem.mapper.CreditCardMapper
import com.ecommerce.oceansale.modules.cartItem.repository.CartItemRepository
import com.ecommerce.oceansale.modules.creditCard.repository.CreditCardRepository
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class CartItemService(val repository: CartItemRepository) {

    fun findAll(): List<CartItemDTO> {
        val allFound = repository.findAll()
        return CartItemMapper.INSTANCE.toDto(allFound)
    }

    fun save(body: CartItemDTO): CartItemDTO {
        body.cartId = IdEncryptor.decrypt(body.cartId!!).toString()
        body.productId = IdEncryptor.decrypt(body.productId!!).toString()
        val toSave = CartItemMapper.INSTANCE.toEntity(body)
        val saved = repository.save(toSave)
        return CartItemMapper.INSTANCE.toDto(saved)
    }

    fun findById(encryptedId: String): CartItemDTO {
        val id = IdEncryptor.decrypt(encryptedId)
        val found = repository.findById(id).orElseThrow { EntityNotFoundException("Product id $id not found") }
        return CartItemMapper.INSTANCE.toDto(found)
    }
}