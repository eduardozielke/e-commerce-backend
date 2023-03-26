package com.ecommerce.oceansale.modules.category.mapper

import com.ecommerce.oceansale.modules.category.dto.CategoryDTO
import com.ecommerce.oceansale.modules.category.entity.Category
import com.ecommerce.oceansale.modules.product.dto.ProductDTO
import com.ecommerce.oceansale.modules.product.entity.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
interface CategoryMapper {

    fun toDto(entity: Category): CategoryDTO

    fun toEntity(dto: CategoryDTO): Category

    fun toDto(entity: List<Category>): List<CategoryDTO>

    fun toEntity(dto: List<CategoryDTO>): List<Category>


    companion object {
        var INSTANCE : CategoryMapper = Mappers.getMapper(CategoryMapper::class.java)
    }
}