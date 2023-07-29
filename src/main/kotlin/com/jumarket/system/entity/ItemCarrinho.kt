package com.jumarket.system.entity

import jakarta.persistence.*

@Entity
data class ItemCarrinho(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "produto_id")
    val produto: Produto,

    val quantidadeItem: Int,

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    var carrinho: CarrinhoDeCompra
)