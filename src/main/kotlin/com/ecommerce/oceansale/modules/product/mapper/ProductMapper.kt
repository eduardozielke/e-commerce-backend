package com.ecommerce.oceansale.modules.product.mapper

import com.ecommerce.oceansale.modules.product.dto.ProductDTO
import com.ecommerce.oceansale.modules.product.entity.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.factory.Mappers

@Mapper
interface ProductMapper {

    fun toDto(entity: Product): ProductDTO

    fun toEntity(dto: ProductDTO): Product

    fun toDto(entity: List<Product>): List<ProductDTO>

    fun toEntity(dto: List<ProductDTO>): List<Product>


    companion object {
        var INSTANCE : ProductMapper = Mappers.getMapper(ProductMapper::class.java)
    }
}