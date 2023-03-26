package com.ecommerce.oceansale.annotations

import com.ecommerce.oceansale.annotations.validator.EmailNotDuplicatedValidator
import jakarta.validation.Constraint
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EmailNotDuplicatedValidator::class])
annotation class EmailNotDuplicated (
    val message: String = "email already exists",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<*>> = []
)