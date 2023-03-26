package com.ecommerce.oceansale.modules.creditCard.repository

import com.ecommerce.oceansale.modules.creditCard.entity.CreditCard
import org.springframework.data.jpa.repository.JpaRepository

interface CreditCardRepository : JpaRepository<CreditCard, Long> {
}