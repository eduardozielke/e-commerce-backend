package com.ecommerce.oceansale.modules.category.controller

import com.ecommerce.oceansale.modules.category.dto.CategoryDTO
import com.ecommerce.oceansale.modules.category.service.CategoryService
import com.ecommerce.oceansale.modules.product.dto.ProductDTO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("categories")
class CategoryController(val service: CategoryService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CategoryDTO>> {
        val found = service.findAll()
        return ResponseEntity(found, HttpStatus.OK)

    }

    @PostMapping
    fun save(@Valid @RequestBody body: CategoryDTO): ResponseEntity<CategoryDTO> {
        val saved = service.save(body)
        return ResponseEntity(saved, HttpStatus.CREATED)
    }
}