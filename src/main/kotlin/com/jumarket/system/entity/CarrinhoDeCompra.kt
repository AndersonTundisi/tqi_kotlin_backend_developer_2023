package com.jumarket.system.entity

import com.jumarket.system.enumeration.FormaPagamento
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*


@Entity
data class CarrinhoDeCompra(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val cpfCliente: String,

    val dataOperacao: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "carrinho", cascade = [CascadeType.ALL])
    val produtos: MutableList<ItemCarrinho> = mutableListOf(),

    val token: String = UUID.randomUUID().toString(),

    @Enumerated(EnumType.STRING)
    var formaPagamento: FormaPagamento? = null
) {


    var valorTotalItens = 0.0

    fun calcularValorTotalItens(): Double {

        for (item in produtos) {
            valorTotalItens += item.produto.valorUnitario * item.quantidadeItem
        }

        return valorTotalItens
    }

}
