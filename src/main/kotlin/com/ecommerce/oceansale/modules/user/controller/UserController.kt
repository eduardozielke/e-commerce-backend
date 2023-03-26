package com.ecommerce.oceansale.modules.user.controller

import com.ecommerce.oceansale.modules.cart.dto.CartDTO
import com.ecommerce.oceansale.modules.user.dto.UserDTO
import com.ecommerce.oceansale.modules.user.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(val service: UserService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<UserDTO>> {
        val found = service.findAll()
        return ResponseEntity(found, HttpStatus.OK)
    }

    @GetMapping("/{encryptedId}")
    fun findById(@PathVariable("encryptedId") encryptedId: String): ResponseEntity<UserDTO> {
        val found = service.findById(encryptedId)
        return ResponseEntity(found, HttpStatus.OK)
    }

    @PostMapping
    fun save(@Valid @RequestBody body: UserDTO): ResponseEntity<UserDTO> {
        val saved = service.save(body)
        return ResponseEntity(saved, HttpStatus.CREATED)
    }

    @DeleteMapping("/{encryptedId}")
    fun delete(@PathVariable("encryptedId") encryptedId: String): ResponseEntity<Any> {
        service.delete(encryptedId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}