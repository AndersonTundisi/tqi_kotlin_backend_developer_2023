package com.jumarket.system.service

import com.jumarket.system.entity.Categoria
import com.jumarket.system.entity.Produto
import com.jumarket.system.enumeration.UnidadeDeMedia
import com.jumarket.system.repository.ProdutoRepository
import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import java.util.*

class ProdutoServiceTest {

    @Mock
    private lateinit var produtoRepository: ProdutoRepository

    @InjectMocks
    private lateinit var produtoService: ProdutoService

    @Test
    fun testBuscarProdutoPorIdExistente() {
        // Dado um id de produto existente
        val idProduto = 1L
        val categoria = Categoria(id = 1, nome = "Eletrônicos")
        val produtoExistente = Produto(id = idProduto, nome = "Smartphone", unidadeDeMedida = UnidadeDeMedia.UNIDADE,
            valorUnitario = 1500.0, quantidadeEstoque = 50, categoria = categoria)
        `when`(produtoRepository.findById(idProduto)).thenReturn(Optional.of(produtoExistente))

        // Quando buscar o produto pelo id
        val produtoEncontrado = produtoService.buscarProdutoPorId(idProduto)

        // Então o produto deve ser encontrado e os atributos devem ser iguais
        assertNotNull(produtoEncontrado)
        assertEquals(produtoExistente.id, produtoEncontrado?.id)
        assertEquals(produtoExistente.nome, produtoEncontrado?.nome)
        assertEquals(produtoExistente.valorUnitario, produtoEncontrado?.valorUnitario)
        assertEquals(produtoExistente.quantidadeEstoque, produtoEncontrado?.quantidadeEstoque)
        assertEquals(produtoExistente.categoria, produtoExistente?.categoria)
    }

    @Test
    fun testBuscarProdutoPorIdNaoExistente() {
        // Dado um id de produto não existente
        val idProduto = 99L
        `when`(produtoRepository.findById(idProduto)).thenReturn(Optional.empty())

        // Quando buscar o produto pelo id
        val produtoEncontrado = produtoService.buscarProdutoPorId(idProduto)

        // Então o produto não deve ser encontrado (deve ser nulo)
        assertNull(produtoEncontrado)
    }

    // Outros testes para os métodos do serviço ProdutoService podem ser adicionados aqui

}