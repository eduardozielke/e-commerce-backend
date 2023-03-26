package com.ecommerce.oceansale.modules.order.service

import com.ecommerce.oceansale.modules.order.dto.OrderDTO
import com.ecommerce.oceansale.modules.order.mapper.OrderMapper
import com.ecommerce.oceansale.modules.order.repository.OrderRepository
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class OrderService(val repository: OrderRepository) {

    fun findAll(): List<OrderDTO> {
        val allFound = repository.findAll()
        return OrderMapper.INSTANCE.toDto(allFound)
    }

    fun save(body: OrderDTO): OrderDTO {
        val toSave = OrderMapper.INSTANCE.toEntity(body)
        val saved = repository.save(toSave)
        return OrderMapper.INSTANCE.toDto(saved)
    }

    fun findById(encryptedId: String): OrderDTO {
        val id = IdEncryptor.decrypt(encryptedId)
        val found = repository.findById(id).orElseThrow { EntityNotFoundException("Order id $id not found") }
        return OrderMapper.INSTANCE.toDto(found)
    }
}