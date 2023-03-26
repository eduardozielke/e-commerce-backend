package com.ecommerce.oceansale.bases

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*

/**
 * A anotação @MappedSuperclass é uma anotação JPA (Java Persistence API) que é usada para indicar que uma classe abstrata é uma superclasse mapeada.
 *
 * Quando uma classe é anotada com @MappedSuperclass, ela não será mapeada para uma tabela do banco de dados, mas suas propriedades serão herdados pelas classes que a estendem, e essas classes estendidas serão mapeadas para tabelas do banco de dados.
 *
 * Isso significa que a classe anotada com @MappedSuperclass não representa uma entidade em si, mas fornece propriedades comuns que são compartilhadas por várias classes que a estendem. Essa anotação é útil quando há um conjunto de propriedades comuns que precisam ser compartilhadas por várias classes de entidades.
 *
 * Por exemplo, se você tiver várias classes de entidades que precisam ter propriedades como id e dataCriacao, você pode criar uma classe abstrata anotada com @MappedSuperclass que contenha essas propriedades e, em seguida, estender todas as suas classes de entidade dessa classe abstrata.
 */

@MappedSuperclass
abstract class BaseEntity {

    abstract var id: Long?

    @Transient
    var encryptedId: String? = null

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
}