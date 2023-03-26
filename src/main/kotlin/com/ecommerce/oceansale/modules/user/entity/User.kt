package com.ecommerce.oceansale.modules.user.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.creditCard.entity.CreditCard
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


@Entity
@Table(name = "users")
class User : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "email", unique = true)
    var email: String? = null

    @Column(name = "password")
    var password: String? = null

    @Column(name = "telephone")
    var telephone: String? = null

    @Column(name = "is_active")
    var isActive: Boolean? = null

    @OneToMany(mappedBy = "user")
    var creditCard: List<CreditCard>? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }
}