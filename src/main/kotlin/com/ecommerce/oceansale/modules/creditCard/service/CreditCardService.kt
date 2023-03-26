package com.ecommerce.oceansale.modules.creditCard.service

import com.ecommerce.oceansale.modules.cartItem.mapper.CreditCardMapper
import com.ecommerce.oceansale.modules.creditCard.dto.CreditCardDTO
import com.ecommerce.oceansale.modules.creditCard.repository.CreditCardRepository
import com.ecommerce.oceansale.utils.crypto.Encryption
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CreditCardService(val repository: CreditCardRepository) {

    @Value("\${security.creditCardKey}")
    private lateinit var creditCardKey: String

    fun findAll(): List<CreditCardDTO> {
        val allFound = repository.findAll()
        return CreditCardMapper.INSTANCE.toDto(allFound).map { creditCardDTO ->
            creditCardDTO.creditCardNumber = Encryption.decrypt(creditCardDTO.creditCardNumber!!, creditCardKey)
            creditCardDTO.creditCardExpirationDate = Encryption.decrypt(creditCardDTO.creditCardExpirationDate!!, creditCardKey)
            creditCardDTO
        }
    }

    fun save(body: CreditCardDTO): CreditCardDTO {
        val toSave = CreditCardMapper.INSTANCE.toEntity(body)
        toSave.creditCardNumber?.let { toSave.creditCardNumber = Encryption.encrypt(it, creditCardKey) }
        toSave.creditCardExpirationDate?.let { toSave.creditCardExpirationDate = Encryption.encrypt(it, creditCardKey) }
        val saved = repository.save(toSave)
        return CreditCardMapper.INSTANCE.toDto(saved)
    }

    fun findById(encryptedId: String): CreditCardDTO {
        val id = IdEncryptor.decrypt(encryptedId)
        val found = repository.findById(id).orElseThrow { EntityNotFoundException("Credit card id $id not found") }
        found.creditCardNumber?.let { found.creditCardNumber = Encryption.decrypt(it, creditCardKey) }
        found.creditCardExpirationDate?.let { found.creditCardExpirationDate = Encryption.decrypt(it, creditCardKey) }
        return CreditCardMapper.INSTANCE.toDto(found)
    }
}