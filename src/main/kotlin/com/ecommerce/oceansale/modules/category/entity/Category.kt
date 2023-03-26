package com.ecommerce.oceansale.modules.category.entity

import com.ecommerce.oceansale.bases.BaseEntity
import com.ecommerce.oceansale.modules.product.entity.Product
import com.ecommerce.oceansale.utils.crypto.IdEncryptor
import jakarta.persistence.*
import org.springframework.jmx.export.annotation.ManagedMetric

@Entity
@Table(name = "categories")
class Category : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @SequenceGenerator(name = "categories_seq", sequenceName = "categories_seq", allocationSize = 1)
    @Column(name = "id")
    override var id: Long? = null

    @Column(name = "description")
    var name: String? = null

    @Column(name = "is_active")
    var isActive: Boolean? = null

    @ManyToMany
    @JoinTable(
        name = "category_product",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "product_id")]
    )
    var products: List<Product>? = null

    @PostLoad
    @PostPersist
    private fun onGetFromDB() {
        encryptedId = IdEncryptor.encrypt(id!!)
    }
}