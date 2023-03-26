package com.ecommerce.oceansale.modules.product.service

import com.ecommerce.oceansale.modules.category.service.CategoryService
import com.ecommerce.oceansale.modules.product.dto.ProductDTO
import com.ecommerce.oceansale.modules.product.mapper.ProductMapper
import com.ecommerce.oceansale.modules.product.repository.ProductRepository
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class ProductService(
    val repository: ProductRepository,
    val categoryService: CategoryService
) {

    fun findAll(): List<ProductDTO> {
        val allFound = repository.findAll()
        return ProductMapper.INSTANCE.toDto(allFound)
    }

    fun save(body: ProductDTO): ProductDTO {
        val categories = categoryService.findEntityById(body.categoryId!!)
        val toSave = ProductMapper.INSTANCE.toEntity(body)
        toSave.categories = categories
        val saved = repository.save(toSave)
        return ProductMapper.INSTANCE.toDto(saved)
    }

    fun findById(encryptedId: String): ProductDTO {
        val id = IdEncryptor.decrypt(encryptedId)
        val found = repository.findById(id).orElseThrow { EntityNotFoundException("Product id $id not found") }
        return ProductMapper.INSTANCE.toDto(found)
    }
}