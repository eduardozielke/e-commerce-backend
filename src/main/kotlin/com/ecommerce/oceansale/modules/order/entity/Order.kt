package com.ecommerce.oceansale.modules.order.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.enums.OrderStatus
import com.ecommerce.oceansale.modules.user.entity.User
import com.ecommerce.oceansale.modules.orderItem.entity.OrderItem
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "orders")
class Order : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: List<OrderItem>? = null

    @Column(name = "total", nullable = false)
    var total: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: OrderStatus? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }
}