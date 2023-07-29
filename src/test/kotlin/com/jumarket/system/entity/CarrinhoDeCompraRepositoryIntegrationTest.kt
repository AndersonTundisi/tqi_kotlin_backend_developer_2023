package com.jumarket.system.entity

import com.jumarket.system.repository.CarrinhoDeCompraRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime


@ActiveProfiles("test")
@DataJpaTest
class CarrinhoDeCompraRepositoryIntegrationTest {

    @Autowired
    private lateinit var carrinhoDeCompraRepository: CarrinhoDeCompraRepository

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Test
    fun testSalvarCarrinhoDeCompra() {
        // Dado um carrinho de compra
        val carrinhoDeCompra = CarrinhoDeCompra(cpfCliente = "12345678900",
            dataOperacao = LocalDateTime.now())

        // Quando salvar o carrinho de compra usando o repository
        val carrinhoDeCompraSalvo = carrinhoDeCompraRepository.save(carrinhoDeCompra)
        entityManager.flush()
        entityManager.clear()

        // Então o carrinho de compra deve ser persistido com sucesso e ter um ID atribuído
        val carrinhoDeCompraPersistido = carrinhoDeCompraRepository.findById(carrinhoDeCompraSalvo.id!!)
        assertEquals(carrinhoDeCompraSalvo.id, carrinhoDeCompraPersistido.get().id)
        assertEquals(carrinhoDeCompra.cpfCliente, carrinhoDeCompraPersistido.get().cpfCliente)
    }

}