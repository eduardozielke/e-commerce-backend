package com.ecommerce.oceansale.modules.creditCard.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.cart.enitty.Cart
import com.ecommerce.oceansale.modules.product.entity.Product
import com.ecommerce.oceansale.modules.user.entity.User
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*

@Entity
@Table(name = "credit_cards")
class CreditCard : BaseEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_cards_seq")
    @SequenceGenerator(name = "credit_cards_seq", sequenceName = "credit_cards_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @Column(name = "credit_card_number")
    var creditCardNumber: String? = null

    @Column(name = "credit_card_expiration_date")
    var creditCardExpirationDate: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }

}