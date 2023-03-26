package com.ecommerce.oceansale.modules.orderItem.dto

import com.ecommerce.oceansale.modules.product.dto.ProductDTO
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

class OrderItemDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null
    var product: ProductDTO? = null
    var quantity: Int? = null
    var price: BigDecimal? = null
}
