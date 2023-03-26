package com.ecommerce.oceansale.annotations.validator

import com.ecommerce.oceansale.annotations.EmailNotDuplicated
import com.ecommerce.oceansale.modules.user.repository.UserRepository
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EmailNotDuplicatedValidator(private val userRepository: UserRepository)  : ConstraintValidator<EmailNotDuplicated, String> {
    override fun isValid(email: String?, context: ConstraintValidatorContext?): Boolean {
       return email != null && !userRepository.existsByEmail(email)
    }
}