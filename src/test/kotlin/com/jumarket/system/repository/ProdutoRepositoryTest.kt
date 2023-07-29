package com.jumarket.system.repository

import com.jumarket.system.entity.Categoria
import com.jumarket.system.entity.Produto
import com.jumarket.system.enumeration.UnidadeDeMedia
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DataJpaTest
class ProdutoRepositoryTest {

    @Autowired
    private lateinit var produtoRepository: ProdutoRepository

    @Test
    fun testBuscarProdutoPorNomeExistente() {
        // Dado um nome de produto existente no banco de dados
        val nomeProduto = "Smartphone"
        val categoria = Categoria(nome = "Eletrônicos")
        val produtoExistente = Produto(nome = nomeProduto, unidadeDeMedida = UnidadeDeMedia.UNIDADE,
            valorUnitario = 1500.0, quantidadeEstoque = 50, categoria = categoria)
        produtoRepository.save(produtoExistente)

        // Quando buscar o produto pelo nome usando o repositório
        val produtoEncontrado = produtoRepository.findByNome(nomeProduto)

        // Então o produto deve ser encontrado e o nome deve ser igual ao fornecido
        assertEquals(nomeProduto, produtoEncontrado?.nome)
    }

    @Test
    fun testBuscarProdutoPorNomeInexistente() {
        // Dado um nome de produto que não existe no banco de dados
        val nomeProdutoInexistente = "Tablet"

        // Quando buscar o produto pelo nome usando o repositório
        val produtoEncontrado = produtoRepository.findByNome(nomeProdutoInexistente)

        // Então o produto não deve ser encontrado (deve ser nulo)
        assertNull(produtoEncontrado)
    }

}
