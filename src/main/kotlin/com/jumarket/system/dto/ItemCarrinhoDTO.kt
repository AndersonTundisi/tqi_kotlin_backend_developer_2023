package com.jumarket.system.dto

data class ItemCarrinhoDTO(
    val id: Long,
    val produto: ProdutoDTO,
    val quantidadeItem: Int
)