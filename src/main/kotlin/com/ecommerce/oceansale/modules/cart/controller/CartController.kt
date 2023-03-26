package com.ecommerce.oceansale.modules.cart.controller

import com.ecommerce.oceansale.modules.cart.dto.CartDTO
import com.ecommerce.oceansale.modules.cart.service.CartService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController(val service: CartService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CartDTO>> {
        val found = service.findAll()
        return ResponseEntity(found, HttpStatus.OK)

    }

    @GetMapping("/{encryptedId}")
    fun findById(@PathVariable("encryptedId") encryptedId: String): ResponseEntity<CartDTO> {
        val found = service.findById(encryptedId)
        return ResponseEntity(found, HttpStatus.OK)
    }

}