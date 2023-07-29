package com.jumarket.system.repository

import com.jumarket.system.entity.Produto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProdutoRepository : JpaRepository<Produto, Long> {

    // Consulta personalizada para buscar produto pelo nome
    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    fun findByNome(nome: String): Produto?

}