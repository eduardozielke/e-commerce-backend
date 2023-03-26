package com.ecommerce.oceansale.modules.cart.enitty

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.cartItem.entity.CartItem
import com.ecommerce.oceansale.modules.creditCard.entity.CreditCard
import com.ecommerce.oceansale.modules.user.entity.User
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*

@Entity
@Table(name = "carts")
class Cart : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carts_seq")
    @SequenceGenerator(name = "carts_seq", sequenceName = "carts_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: User? = null

    @OneToMany(mappedBy = "cart")
    val items: List<CartItem> = emptyList()

    @Column(name = "total")
    val total: Long? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }
}