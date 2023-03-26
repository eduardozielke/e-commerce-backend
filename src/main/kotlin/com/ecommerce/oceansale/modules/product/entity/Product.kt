package com.ecommerce.oceansale.modules.product.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.category.entity.Category
import com.ecommerce.oceansale.modules.product.dto.ProductDTO
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "products")
class Product : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    var price: BigDecimal? = null

    @Column(name = "image")
    var image: String? = null

    @Column(name = "quantity", nullable = false)
    var quantity: Long? = null

    @ManyToMany(mappedBy = "products")
    var categories: List<Category>? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }

}