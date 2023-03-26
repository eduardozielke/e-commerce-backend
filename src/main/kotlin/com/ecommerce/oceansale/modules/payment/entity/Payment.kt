package com.ecommerce.oceansale.modules.payment.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.enums.PaymentStatus
import com.ecommerce.oceansale.modules.order.entity.Order
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*

@Entity
@Table(name = "payments")
class Payment : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payments_seq")
    @SequenceGenerator(name = "payments_seq", sequenceName = "payments_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null

    @Column(name = "amount")
    var amount: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: PaymentStatus? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }

}