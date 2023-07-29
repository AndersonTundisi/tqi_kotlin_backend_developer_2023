package com.jumarket.system.repository

import com.jumarket.system.entity.CarrinhoDeCompra
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime
@ActiveProfiles("test")
@DataJpaTest
class CarrinhoDeCompraRepositoryTest {

    @Autowired
    private lateinit var carrinhoDeCompraRepository: CarrinhoDeCompraRepository

    @Test
    fun testBuscarCarrinhoPorCpfClienteExistente() {
        // Dado um CPF de cliente existente no banco de dados
        val cpfCliente = "12345678900"
        val carrinhoExistente = CarrinhoDeCompra(cpfCliente = cpfCliente, dataOperacao = LocalDateTime.now())
        carrinhoDeCompraRepository.save(carrinhoExistente)

        // Quando buscar os carrinhos de compra pelo CPF do cliente usando o repositório
        val carrinhosEncontrados = carrinhoDeCompraRepository.findByCpfCliente(cpfCliente)

        // Então a lista de carrinhos deve conter pelo menos um carrinho
        assertEquals(1, carrinhosEncontrados.size)
        // Verifique outras propriedades dos carrinhos encontrados, se necessário
    }

    @Test
    fun testBuscarCarrinhoPorCpfClienteInexistente() {
        // Dado um CPF de cliente que não existe no banco de dados
        val cpfClienteInexistente = "98765432100"

        // Quando buscar os carrinhos de compra pelo CPF do cliente usando o repositório
        val carrinhosEncontrados = carrinhoDeCompraRepository.findByCpfCliente(cpfClienteInexistente)

        // Então a lista de carrinhos deve estar vazia (não deve conter nenhum carrinho)
        assertTrue(carrinhosEncontrados.isEmpty())
    }

}