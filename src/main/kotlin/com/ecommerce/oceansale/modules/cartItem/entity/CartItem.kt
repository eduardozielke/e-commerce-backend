package com.ecommerce.oceansale.modules.cartItem.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.cart.enitty.Cart
import com.ecommerce.oceansale.modules.product.entity.Product
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "cart_items")
class CartItem : BaseEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carts_items_seq")
    @SequenceGenerator(name = "carts_items_seq", sequenceName = "carts_items_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product? = null

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    val cart: Cart? = null

    @Column(name = "quantity", nullable = false)
    val quantity: Int? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }

}