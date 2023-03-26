package com.ecommerce.oceansale.modules.product.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime

class ProductDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null
    var name: String? = null
    var description: String? = null
    var price: BigDecimal? = null
    var image: String? = null
    var quantity: Long? = null
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var categoryId: List<String>? = null
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var createdAt: LocalDateTime? = null
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var updatedAt: LocalDateTime? = null
}