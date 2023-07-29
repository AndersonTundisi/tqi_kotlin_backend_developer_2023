package com.jumarket.system.controller

import com.jumarket.system.entity.Produto
import com.jumarket.system.service.ProdutoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")

class ProdutoController(private val produtoService: ProdutoService) {

    @PostMapping
    fun criarProduto(@RequestBody produto: Produto): Produto {
        return produtoService.salvarProduto(produto)
    }

    @GetMapping("/{id}")
    fun buscarProdutoPorId(@PathVariable id: Long): ResponseEntity<Produto> {
        val produto = produtoService.buscarProdutoPorId(id)

        return if (produto != null) {
            ResponseEntity.ok(produto)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun buscarTodosProdutos(): List<Produto> {
        return produtoService.buscarTodosProdutos()
    }

    @PutMapping("/{id}")
    fun atualizarProduto(@PathVariable id: Long, @RequestBody produto: Produto): ResponseEntity<Produto> {
        val produtoExistente = produtoService.buscarProdutoPorId(id)

        if (produtoExistente != null) {
            produtoService.atualizarProduto(produto.copy(id = id))
            return ResponseEntity.ok(produto)
        }

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun excluirProduto(@PathVariable id: Long): ResponseEntity<Void> {
        val produtoExistente = produtoService.buscarProdutoPorId(id)

        if (produtoExistente != null) {
            produtoService.excluirProdutoPorId(id)
            return ResponseEntity.noContent().build()
        }

        return ResponseEntity.notFound().build()
    }
}