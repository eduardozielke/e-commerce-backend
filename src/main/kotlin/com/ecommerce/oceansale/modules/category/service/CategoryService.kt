package com.ecommerce.oceansale.modules.category.service

import com.ecommerce.oceansale.modules.category.dto.CategoryDTO
import com.ecommerce.oceansale.modules.category.entity.Category
import com.ecommerce.oceansale.modules.category.mapper.CategoryMapper
import com.ecommerce.oceansale.modules.category.repository.CategoryRepository
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import org.springframework.stereotype.Service

@Service
class CategoryService(val repository: CategoryRepository) {

    fun findAll(): List<CategoryDTO> {
        val allFound = repository.findAll()
        return CategoryMapper.INSTANCE.toDto(allFound)
    }

    fun save(body: CategoryDTO): CategoryDTO {
        val toSave = CategoryMapper.INSTANCE.toEntity(body)
        val saved = repository.save(toSave)
        return CategoryMapper.INSTANCE.toDto(saved)
    }

    fun findEntityById(encryptedIds: List<String>): List<Category> {
        val ids = encryptedIds.map { encryptedId -> IdEncryptor.decrypt(encryptedId)}
        return repository.findByIds(ids)
    }

    fun existsById(encryptedId: String): Boolean {
        val id = IdEncryptor.decrypt(encryptedId)
        return repository.existsById(id)
    }

}