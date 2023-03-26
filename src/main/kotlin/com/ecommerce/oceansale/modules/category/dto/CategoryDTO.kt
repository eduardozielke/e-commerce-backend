package com.ecommerce.oceansale.modules.category.dto

import com.fasterxml.jackson.annotation.JsonProperty

class CategoryDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null
    var name: String? = null
    var isActive: Boolean? = null
}