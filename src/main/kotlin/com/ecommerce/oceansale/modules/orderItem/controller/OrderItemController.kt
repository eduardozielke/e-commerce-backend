package com.ecommerce.oceansale.modules.orderItem.controller

import com.ecommerce.oceansale.modules.cart.dto.CartDTO
import com.ecommerce.oceansale.modules.orderItem.dto.OrderItemDTO
import com.ecommerce.oceansale.modules.orderItem.service.OrderItemService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order-items")
class OrderItemController(val service: OrderItemService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<OrderItemDTO>> {
        val found = service.findAll()
        return ResponseEntity(found, HttpStatus.OK)

    }

    @GetMapping("/{encryptedId}")
    fun findById(@PathVariable("encryptedId") encryptedId: String): ResponseEntity<OrderItemDTO> {
        val found = service.findById(encryptedId)
        return ResponseEntity(found, HttpStatus.OK)
    }

    @PostMapping
    fun save(@Valid @RequestBody body: OrderItemDTO): ResponseEntity<OrderItemDTO> {
        val saved = service.save(body)
        return ResponseEntity(saved, HttpStatus.CREATED)
    }
}