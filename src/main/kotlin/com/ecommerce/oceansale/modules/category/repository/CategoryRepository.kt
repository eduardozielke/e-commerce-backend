package com.ecommerce.oceansale.modules.category.repository

import com.ecommerce.oceansale.modules.category.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}