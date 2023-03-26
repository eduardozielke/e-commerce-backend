package com.ecommerce.oceansale.utils.crypto

import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import java.util.Base64


object Encryption {

    private const val ALGORITHM = "AES"
    private const val TRANSFORMATION = "AES/ECB/PKCS5Padding"
    private const val CHARSET = "UTF-8"

    fun encrypt(value: String, secret: String): String {
        val key = SecretKeySpec(getHashedSecret(secret), ALGORITHM)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptedValue = cipher.doFinal(value.toByteArray(charset(CHARSET)))
        return Base64.getEncoder().encodeToString(encryptedValue)
    }

    fun decrypt(encryptedValue: String, secret: String): String {
        val key = SecretKeySpec(getHashedSecret(secret), ALGORITHM)
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, key)
        val decryptedValue = cipher.doFinal(Base64.getDecoder().decode(encryptedValue))
        return String(decryptedValue, charset(CHARSET))
    }

    private fun getHashedSecret(secret: String): ByteArray {
        val messageDigest = MessageDigest.getInstance("SHA-256")
        return messageDigest.digest(secret.toByteArray(charset(CHARSET)))
    }
}


/**
 * /*
 * This is a Kotlin object named "EncryptionUtils" that contains two functions for encrypting and decrypting a string using AES encryption. The encryption function, "encrypt", takes in two parameters: a plaintext string to encrypt and a secret key. The decryption function, "decrypt", takes in two parameters: an encrypted string to decrypt and the same secret key used for encryption.
 *
 * The object uses a constant string named "ALGORITHM" to specify the encryption algorithm, which is set to "AES". The constant string named "TRANSFORMATION" is used to specify the transformation of the encryption algorithm along with the padding scheme, which is set to "AES/ECB/PKCS5Padding". The constant string named "CHARSET" is used to specify the character encoding, which is set to "UTF-8".
 *
 * The "encrypt" function takes the plaintext string and the secret key and converts the secret key into a SecretKeySpec object using the hashed version of the secret key obtained by calling the "getHashedSecret" function. It then initializes a Cipher object with the transformation specified in the "TRANSFORMATION" constant and initializes it with the secret key in encryption mode. It encrypts the plaintext string using the Cipher's doFinal method and encodes the resulting encrypted bytes as a Base64-encoded string using Android's Base64 utility class. It returns the resulting encrypted string.
 *
 * The "decrypt" function takes the encrypted string and the secret key and converts the secret key into a SecretKeySpec object using the hashed version of the secret key obtained by calling the "getHashedSecret" function. It then initializes a Cipher object with the transformation specified in the "TRANSFORMATION" constant and initializes it with the secret key in decryption mode. It decrypts the Base64-encoded encrypted string using the Cipher's doFinal method and decodes the resulting decrypted bytes using Android's Base64 utility class. It returns the resulting decrypted string.
 *
 * The "getHashedSecret" function takes in the secret key and obtains the SHA-256 hash of the secret key using the MessageDigest utility class. It returns the resulting hash as a byte array.
 *  */
 */