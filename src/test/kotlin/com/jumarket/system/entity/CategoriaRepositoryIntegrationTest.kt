package com.jumarket.system.entity

import com.jumarket.system.repository.CategoriaRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DataJpaTest
class CategoriaRepositoryIntegrationTest {

    @Autowired
    private lateinit var categoriaRepository: CategoriaRepository

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Test
    fun testSalvarCategoria() {
        // Dado uma categoria
        val categoria = Categoria(nome = "Eletrônicos")

        // Quando salvar a categoria usando o repository
        val categoriaSalva = categoriaRepository.save(categoria)
        entityManager.flush()
        entityManager.clear()

        // Então a categoria deve ser persistida com sucesso e ter um ID atribuído
        val categoriaPersistida = categoriaRepository.findById(categoriaSalva.id!!)
        assertEquals(categoriaSalva.id, categoriaPersistida.get().id)
        assertEquals(categoria.nome, categoriaPersistida.get().nome)
    }

}