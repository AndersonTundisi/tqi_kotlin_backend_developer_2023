package com.jumarket.system.service

import com.jumarket.system.repository.CategoriaRepository
import com.jumarket.system.entity.Categoria
import org.springframework.stereotype.Service

@Service
class CategoriaService(private val categoriaRepository: CategoriaRepository) {

    fun salvarCategoria(categoria: Categoria): Categoria {
        return categoriaRepository.save(categoria)
    }

    fun buscarCategoriaPorId(id: Long): Categoria? {
        return categoriaRepository.findById(id).orElse(null)
    }

    fun buscarTodasCategorias(): List<Categoria> {
        return categoriaRepository.findAll()
    }

    fun atualizarCategoria(categoria: Categoria): Categoria {
        return categoriaRepository.save(categoria)
    }

    fun excluirCategoriaPorId(id: Long) {
        categoriaRepository.deleteById(id)
    }
}