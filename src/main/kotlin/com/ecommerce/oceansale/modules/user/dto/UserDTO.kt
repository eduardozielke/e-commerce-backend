package com.ecommerce.oceansale.modules.user.dto

import com.ecommerce.oceansale.annotations.EmailNotDuplicated
import com.ecommerce.oceansale.modules.user.entity.User
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var encryptedId: String? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 5, max = 30, message = "The field must be between 5 and 30 characters long")
    var password: String? = null
    @Email(message = "the email address is not valid")
    @EmailNotDuplicated
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var telephone: String? = null
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var isActive = true
}