package com.jumarket.system.controller

import com.jumarket.system.repository.CarrinhoDeCompraRepository
import com.jumarket.system.service.CarrinhoDeCompraService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@Autowired
private lateinit var mockMvc: MockMvc

class CarrinhoDeCompraControllerTest {

    @ExtendWith(SpringExtension::class)
    @WebMvcTest(CarrinhoDeCompraController::class)
        class CarrinhoDeCompraControllerTest

        @MockBean
        lateinit var carrinhoDeCompraRepository: CarrinhoDeCompraRepository
        @MockBean
        lateinit var carrinhoDeCompraService: CarrinhoDeCompraService
        @Test
        fun testBuscarCarrinhoPorIdExistente() {
            // Dado um ID de carrinho existente
            val idCarrinho = 1

            // Quando fazer uma solicitação GET para o endpoint /carrinhos/{id}
            mockMvc.perform(MockMvcRequestBuilders.get("/carrinhos/$idCarrinho"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(idCarrinho))

        }

        @Test
        fun testBuscarCarrinhoPorIdNaoExistente() {
            // Dado um ID de carrinho que não existe no banco de dados
            val idCarrinhoNaoExistente = 99

            // Quando fazer uma solicitação GET para o endpoint /carrinhos/{id}
            mockMvc.perform(MockMvcRequestBuilders.get("/carrinhos/$idCarrinhoNaoExistente"))
                .andExpect(MockMvcResultMatchers.status().isNotFound)
        }


    }