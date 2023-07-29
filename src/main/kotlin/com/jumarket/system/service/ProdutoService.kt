package com.jumarket.system.service

import com.jumarket.system.repository.ProdutoRepository
import com.jumarket.system.entity.Produto
import org.springframework.stereotype.Service

@Service
class ProdutoService(private val produtoRepository: ProdutoRepository) {

    fun salvarProduto(produto: Produto): Produto {
        return produtoRepository.save(produto)
    }

    fun buscarProdutoPorId(id: Long): Produto? {
        return produtoRepository.findById(id).orElse(null)
    }

    fun buscarTodosProdutos(): List<Produto> {
        return produtoRepository.findAll()
    }

    fun atualizarProduto(produto: Produto): Produto {
        return produtoRepository.save(produto)
    }

    fun excluirProdutoPorId(id: Long) {
        produtoRepository.deleteById(id)
    }
}