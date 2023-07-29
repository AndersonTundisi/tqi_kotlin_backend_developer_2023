package com.jumarket.system.dto

import com.jumarket.system.enumeration.FormaPagamento
import java.time.LocalDateTime

data class CarrinhoDeCompraDTO(
    val id: Long,
    val cpfCliente: String,
    val dataOperacao: LocalDateTime,
    val produtos: List<ItemCarrinhoDTO>,
    val token: String,
    val formaPagamento: FormaPagamento?,
    val valorTotalItens: Double
)