package com.ecommerce.oceansale.modules.creditCard.controller

import com.ecommerce.oceansale.modules.creditCard.dto.CreditCardDTO
import com.ecommerce.oceansale.modules.creditCard.service.CreditCardService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/credit-cards")
class CreditCardController(val service: CreditCardService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<CreditCardDTO>> {
        val found = service.findAll()
        return ResponseEntity(found, HttpStatus.OK)

    }

    @GetMapping("/{encryptedId}")
    fun findById(@PathVariable("encryptedId") encryptedId: String): ResponseEntity<CreditCardDTO> {
        val found = service.findById(encryptedId)
        return ResponseEntity(found, HttpStatus.OK)
    }

    @PostMapping
    fun save(@Valid @RequestBody body: CreditCardDTO): ResponseEntity<CreditCardDTO> {
        val saved = service.save(body)
        return ResponseEntity(saved, HttpStatus.CREATED)
    }
}