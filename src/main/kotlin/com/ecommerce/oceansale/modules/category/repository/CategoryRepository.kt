package com.ecommerce.oceansale.modules.category.repository

import com.ecommerce.oceansale.modules.category.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CategoryRepository : JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.id IN :ids")
    fun findByIds(ids: List<Long>): List<Category>
}