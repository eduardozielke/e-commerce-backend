package com.ecommerce.oceansale.modules.creditCard.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

class CreditCardDTO{

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null
    @NotBlank(message = "Credit card number is required.")
    var creditCardNumber: String? = null

    @NotBlank(message = "Credit card expiration date is required.")
    var creditCardExpirationDate: String? = null
}