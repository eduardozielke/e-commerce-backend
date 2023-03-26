package com.ecommerce.oceansale.modules.discount.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*

@Entity
@Table(name = "discounts")
class Discount : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discounts_seq")
    @SequenceGenerator(name = "discounts_seq", sequenceName = "discounts_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "discount_percent")
    var discountPercent: Int? = null

    @Column(name = "is_active")
    var isActive: Boolean? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }
}