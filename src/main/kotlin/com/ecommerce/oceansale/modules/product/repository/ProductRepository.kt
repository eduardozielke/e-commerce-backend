package com.ecommerce.oceansale.modules.product.repository

import com.ecommerce.oceansale.modules.product.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
}