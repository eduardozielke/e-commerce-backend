package com.ecommerce.oceansale.modules.address.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.user.entity.User
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*

@Entity
@Table(name = "adresses")
class Address : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adresses_seq")
    @SequenceGenerator(name = "adresses_seq", sequenceName = "adresses_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @Column(name = "address_line_1")
    var addressLine1: String? = null

    @Column(name = "address_line_2")
    var addressLine2: String? = null

    @Column(name = "city")
    var city: String? = null

    @Column(name = "state")
    var state: String? = null

    @Column(name = "zip_code")
    var zipCode: String? = null

    @Column(name = "country")
    var country: String? = null

    @Column(name = "telephone")
    var telephone: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }
}