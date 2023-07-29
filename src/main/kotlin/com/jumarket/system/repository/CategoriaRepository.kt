package com.jumarket.system.repository

import com.jumarket.system.entity.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository : JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c WHERE c.nome = :nome")
    fun findByNome(nome: String): Categoria?

}