package com.ecommerce.oceansale.modules.orderItem.service

import com.ecommerce.oceansale.modules.orderItem.dto.OrderItemDTO
import com.ecommerce.oceansale.modules.orderItem.mapper.OrderItemMapper
import com.ecommerce.oceansale.modules.orderItem.repository.OrderItemRepository
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class OrderItemService(val repository: OrderItemRepository) {

    fun findAll(): List<OrderItemDTO> {
        val allFound = repository.findAll()
        return OrderItemMapper.INSTANCE.toDto(allFound)
    }

    fun save(body: OrderItemDTO): OrderItemDTO {
        val toSave = OrderItemMapper.INSTANCE.toEntity(body)
        val saved = repository.save(toSave)
        return OrderItemMapper.INSTANCE.toDto(saved)
    }

    fun findById(encryptedId: String): OrderItemDTO {
        val id = IdEncryptor.decrypt(encryptedId)
        val found = repository.findById(id).orElseThrow { EntityNotFoundException("Product id $id not found") }
        return OrderItemMapper.INSTANCE.toDto(found)
    }
}