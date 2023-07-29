package com.jumarket.system.dto

data class ProdutoDTO(
    val id: Long,
    val nome: String,
    val unidadeDeMedida: String,
    val valorUnitario: Double,
    var quantidadeEstoque: Int,
    val categoria: CategoriaDTO,
    val codigoProduto: String
)