package com.ecommerce.oceansale.exception

import java.time.LocalDateTime

class ErrorResponse (
    var message: String,
    var status: Int,
    var path: String,
    var timestamp: LocalDateTime = LocalDateTime.now(),
)