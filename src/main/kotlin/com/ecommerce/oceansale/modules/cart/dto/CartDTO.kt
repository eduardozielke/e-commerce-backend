package com.ecommerce.oceansale.modules.cart.dto

import com.ecommerce.oceansale.modules.cartItem.dto.CartItemDTO
import com.ecommerce.oceansale.modules.creditCard.entity.CreditCard
import com.fasterxml.jackson.annotation.JsonProperty

class CartDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null
     var items: List<CartItemDTO> = emptyList()
}