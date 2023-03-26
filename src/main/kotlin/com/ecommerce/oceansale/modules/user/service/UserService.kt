package com.ecommerce.oceansale.modules.user.service

import com.ecommerce.oceansale.modules.user.dto.UserDTO
import com.ecommerce.oceansale.modules.user.mapper.UserMapper
import com.ecommerce.oceansale.modules.user.repository.UserRepository
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(val repository: UserRepository) {

    fun findAll(): List<UserDTO> {
        val allFound = repository.findAll()
        return UserMapper.INSTANCE.toDto(allFound)
    }

    fun save(body: UserDTO): UserDTO {
        val toSave = UserMapper.INSTANCE.toEntity(body)
        val saved = repository.save(toSave)
        return UserMapper.INSTANCE.toDto(saved)
    }

    fun findById(encryptedId: String): UserDTO {
        val id = IdEncryptor.decrypt(encryptedId)
        val found = repository.findById(id).orElseThrow { EntityNotFoundException("user id $id not found") }
        return UserMapper.INSTANCE.toDto(found)
    }

    fun delete(encryptedId: String) {
        val id = IdEncryptor.decrypt(encryptedId)
        repository.deleteById(id)
    }
}