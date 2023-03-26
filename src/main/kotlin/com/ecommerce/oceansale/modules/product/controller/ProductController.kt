package com.ecommerce.oceansale.modules.product.controller

import com.ecommerce.oceansale.modules.product.dto.ProductDTO
import com.ecommerce.oceansale.modules.product.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class ProductController(val service: ProductService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductDTO>> {
        val found = service.findAll()
        return ResponseEntity(found, HttpStatus.OK)

    }

    @GetMapping("/{encryptedId}")
    fun findById(@PathVariable("encryptedId") encryptedId: String): ResponseEntity<ProductDTO> {
        val found = service.findById(encryptedId)
        return ResponseEntity(found, HttpStatus.OK)
    }

    @PostMapping
    fun save(@Valid @RequestBody body: ProductDTO): ResponseEntity<ProductDTO> {
        val saved = service.save(body)
        return ResponseEntity(saved, HttpStatus.CREATED)
    }
}