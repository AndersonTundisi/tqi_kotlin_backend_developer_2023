package com.jumarket.system.controller

import com.jumarket.system.entity.Categoria
import com.jumarket.system.service.CategoriaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categorias")
class CategoriaController(private val categoriaService: CategoriaService) {

    @PostMapping
    fun criarCategoria(@RequestBody categoria: Categoria): Categoria {
        return categoriaService.salvarCategoria(categoria)
    }

    @GetMapping("/{id}")
    fun buscarCategoriaPorId(@PathVariable id: Long): ResponseEntity<Categoria> {
        val categoria = categoriaService.buscarCategoriaPorId(id)

        return if (categoria != null) {
            ResponseEntity.ok(categoria)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun buscarTodasCategorias(): List<Categoria> {
        return categoriaService.buscarTodasCategorias()
    }

    @PutMapping("/{id}")
    fun atualizarCategoria(@PathVariable id: Long, @RequestBody categoria: Categoria): ResponseEntity<Categoria> {
        val categoriaExistente = categoriaService.buscarCategoriaPorId(id)

        if (categoriaExistente != null) {
            categoriaService.atualizarCategoria(categoria.copy(id = id))
            return ResponseEntity.ok(categoria)
        }

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun excluirCategoria(@PathVariable id: Long): ResponseEntity<Void> {
        val categoriaExistente = categoriaService.buscarCategoriaPorId(id)

        if (categoriaExistente != null) {
            categoriaService.excluirCategoriaPorId(id)
            return ResponseEntity.noContent().build()
        }

        return ResponseEntity.notFound().build()
    }
}