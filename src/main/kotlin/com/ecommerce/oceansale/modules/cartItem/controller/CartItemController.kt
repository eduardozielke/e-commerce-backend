package com.ecommerce.oceansale.modules.cartItem.controller

import com.ecommerce.oceansale.modules.cartItem.dto.CartItemDTO
import com.ecommerce.oceansale.modules.cartItem.service.CartItemService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart-items")
class CartItemController(val service: CartItemService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CartItemDTO>> {
        val found = service.findAll()
        return ResponseEntity(found, HttpStatus.OK)

    }

    @GetMapping("/{encryptedId}")
    fun findById(@PathVariable("encryptedId") encryptedId: String): ResponseEntity<CartItemDTO> {
        val found = service.findById(encryptedId)
        return ResponseEntity(found, HttpStatus.OK)
    }

    @PostMapping
    fun save(@Valid @RequestBody body: CartItemDTO): ResponseEntity<CartItemDTO> {
        val saved = service.save(body)
        return ResponseEntity(saved, HttpStatus.CREATED)
    }
}