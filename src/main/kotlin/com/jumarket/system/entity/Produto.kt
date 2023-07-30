package com.jumarket.system.entity

import com.jumarket.system.enumeration.UnidadeDeMedia
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "produto")
data class Produto(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(nullable = false) val nome: String,
    @Column(nullable = false) @Enumerated val unidadeDeMedida: UnidadeDeMedia,
    @Column(nullable = false) val valorUnitario: Double,
    @Column(nullable = false) var quantidadeEstoque: Int,
    @ManyToOne @JoinColumn(name = "categoria_id") val categoria: Categoria,
    @Column(columnDefinition = "BINARY(16)") val codeProduto: String = UUID.randomUUID().toString()
)

