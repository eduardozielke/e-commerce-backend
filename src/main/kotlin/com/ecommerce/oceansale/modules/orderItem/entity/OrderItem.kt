package com.ecommerce.oceansale.modules.orderItem.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.order.entity.Order
import com.ecommerce.oceansale.modules.product.entity.Product
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "order_items")
class OrderItem : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_items_seq")
    @SequenceGenerator(name = "order_items_seq", sequenceName = "order_items_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    var order: Order? = null

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product? = null

    @Column(name = "quantity", nullable = false)
    var quantity: Int? = null

    @Column(name = "price", nullable = false)
    var price: BigDecimal? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }
}