package com.jumarket.system.service

import com.jumarket.system.entity.CarrinhoDeCompra
import com.jumarket.system.repository.CarrinhoDeCompraRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import java.time.LocalDateTime
import java.util.*

class CarrinhoDeCompraServiceTest {

    @Mock
    private lateinit var carrinhoDeCompraRepository: CarrinhoDeCompraRepository

    @InjectMocks
    private lateinit var carrinhoDeCompraService: CarrinhoDeCompraService

    @Test
    fun testBuscarCarrinhoPorIdExistente() {
        // Dado um id de carrinho existente
        val idCarrinho = 1L
        val carrinhoExistente = CarrinhoDeCompra(id = idCarrinho, cpfCliente = "12345678900",
            dataOperacao = LocalDateTime.now(), produtos = mutableListOf())
        `when`(carrinhoDeCompraRepository.findById(idCarrinho)).thenReturn(Optional.of(carrinhoExistente))

        // Quando buscar o carrinho pelo id
        val carrinhoEncontrado = carrinhoDeCompraService.buscarCarrinhoPorId(idCarrinho)

        // Então o carrinho deve ser encontrado e os atributos devem ser iguais
        assertNotNull(carrinhoEncontrado)
        assertEquals(carrinhoExistente.id, carrinhoEncontrado?.id)
        assertEquals(carrinhoExistente.cpfCliente, carrinhoEncontrado?.cpfCliente)

    }

    @Test
    fun testBuscarCarrinhoPorIdNaoExistente() {
        // Dado um id de carrinho não existente
        val idCarrinho = 99L
        `when`(carrinhoDeCompraRepository.findById(idCarrinho)).thenReturn(Optional.empty())

        // Quando buscar o carrinho pelo id
        val carrinhoEncontrado = carrinhoDeCompraService.buscarCarrinhoPorId(idCarrinho)

        // Então o carrinho não deve ser encontrado (deve ser nulo)
        assertNull(carrinhoEncontrado)
    }

    // Outros testes para os métodos do serviço CarrinhoDeCompraService podem ser adicionados aqui

}