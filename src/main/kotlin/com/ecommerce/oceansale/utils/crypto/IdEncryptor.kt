package com.ecommerce.oceansale.utils.crypto

import com.ecommerce.oceansale.exception.customException.DecryptionException
import java.util.Base64
import kotlin.experimental.xor

object IdEncryptor {

    fun encrypt(input: Long, key: String = "criptografia"): String {
        try {
            val inputBytes = input.toString().toByteArray(charset("UTF-8"))
            val keyBytes = key.toByteArray(charset("UTF-8"))

            for (i in inputBytes.indices) {
                inputBytes[i] = inputBytes[i] xor keyBytes[i % keyBytes.size]
            }

            return Base64.getEncoder().encodeToString(inputBytes)
        } catch (e: Exception) {
            throw DecryptionException("error encrypting id: $input")
        }
    }

    fun decrypt(input: String, key: String = "criptografia"): Long {
        try {
            val inputBytes = Base64.getDecoder().decode(input)
            val keyBytes = key.toByteArray(charset("UTF-8"))

            for (i in inputBytes.indices) {
                inputBytes[i] = inputBytes[i] xor keyBytes[i % keyBytes.size]
            }

            return String(inputBytes, charset("UTF-8")).toLong()
        } catch (e: Exception) {
            throw DecryptionException("error decrypting id: $input")
        }
    }

}