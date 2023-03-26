package com.ecommerce.oceansale.modules.cart.service

import com.ecommerce.oceansale.modules.cart.dto.CartDTO
import com.ecommerce.oceansale.modules.cart.mapper.CartMapper
import com.ecommerce.oceansale.modules.cart.repository.CartRepository
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(val repository: CartRepository) {

    @Transactional
    fun findAll(): List<CartDTO> {
        val allFound = repository.findAll()
        return CartMapper.INSTANCE.toDto(allFound)
    }

    @Transactional
    fun findById(encryptedId: String): CartDTO {
        val id = IdEncryptor.decrypt(encryptedId)
        val found = repository.findById(id).orElseThrow { EntityNotFoundException("cart id $id not found") }
        return CartMapper.INSTANCE.toDto(found)
    }
}