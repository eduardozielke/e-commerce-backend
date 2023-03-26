package com.ecommerce.oceansale.annotations.validator

import com.ecommerce.oceansale.modules.category.service.CategoryService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class CategoryIdValidator(private val categoryService: CategoryService) : ConstraintValidator<ValidCategoryId, String> {
    override fun isValid(categoryId: String?, context: ConstraintValidatorContext?): Boolean {
        // Aqui, você pode usar o seu serviço que acessa a tabela categories para verificar se o id existe
        return categoryId != null && categoryService.existsById(categoryId)
    }
}