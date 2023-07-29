package com.jumarket.system.entity

import com.jumarket.system.enumeration.UnidadeDeMedia
import com.jumarket.system.repository.ProdutoRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DataJpaTest
class ProdutoRepositoryIntegrationTest {

    @Autowired
    private lateinit var produtoRepository: ProdutoRepository

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Test
    fun testSalvarProduto() {
        // Dado um produto
        val categoria = Categoria(nome = "Eletrônicos")
        val produto = Produto(nome = "Smartphone", unidadeDeMedida = UnidadeDeMedia.UNIDADE,
            valorUnitario = 1500.0, quantidadeEstoque = 50, categoria = categoria)

        // Quando salvar o produto usando o repository
        val produtoSalvo = produtoRepository.save(produto)
        entityManager.flush()
        entityManager.clear()

        // Então o produto deve ser persistido com sucesso e ter um ID atribuído
        val produtoPersistido = produtoRepository.findById(produtoSalvo.id!!)
        assertEquals(produtoSalvo.id, produtoPersistido.get().id)
        assertEquals(produto.nome, produtoPersistido.get().nome)
    }

}