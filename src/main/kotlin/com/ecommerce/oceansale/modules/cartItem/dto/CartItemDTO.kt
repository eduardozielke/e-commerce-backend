package com.ecommerce.oceansale.modules.cartItem.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

class CartItemDTO{

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null
    @NotBlank(message = "productId must not be null")
    var productId: String? = null
    @NotBlank(message = "cartId must not be null")
    var cartId: String? = null
    var quantity: Int? = null
}