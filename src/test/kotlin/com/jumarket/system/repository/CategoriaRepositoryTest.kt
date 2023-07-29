package com.jumarket.system.repository

import com.jumarket.system.entity.Categoria
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DataJpaTest
class CategoriaRepositoryTest {

    @Autowired
    private lateinit var categoriaRepository: CategoriaRepository

    @Test
    fun testBuscarCategoriaPorNomeExistente() {
        // Dado um nome de categoria existente no banco de dados
        val nomeCategoria = "Eletrônicos"
        val categoriaExistente = Categoria(nome = nomeCategoria)
        categoriaRepository.save(categoriaExistente)

        // Quando buscar a categoria pelo nome usando o repositório
        val categoriaEncontrada = categoriaRepository.findByNome(nomeCategoria)

        // Então a categoria deve ser encontrada e o nome deve ser igual ao fornecido
        assertEquals(nomeCategoria, categoriaEncontrada?.nome)
    }

    @Test
    fun testBuscarCategoriaPorNomeInexistente() {
        // Dado um nome de categoria que não existe no banco de dados
        val nomeCategoriaInexistente = "Esportes"

        // Quando buscar a categoria pelo nome usando o repositório
        val categoriaEncontrada = categoriaRepository.findByNome(nomeCategoriaInexistente)

        // Então a categoria não deve ser encontrada (deve ser nula)
        assertNull(categoriaEncontrada)
    }

}