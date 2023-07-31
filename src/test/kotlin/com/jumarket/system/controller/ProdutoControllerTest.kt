package com.jumarket.system.controller

import com.jumarket.system.repository.ProdutoRepository
import com.jumarket.system.service.ProdutoService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@Autowired
private lateinit var mockMvc: MockMvc

class ProdutoControllerTest {

    @ExtendWith(SpringExtension::class)
    @WebMvcTest(ProdutoController::class)
        class ProdutoControllerTest
    @MockBean
    lateinit var produtoRepository: ProdutoRepository
    @MockBean
    lateinit var produtoService: ProdutoService

    @Test
    fun testBuscarProdutoPorIdExistente() {
        // Dado um ID de produto existente
        val idProduto = 1

        // Quando fazer uma solicitação GET para o endpoint /produtos/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/produtos/$idProduto"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(idProduto))

    }

    @Test
    fun testBuscarProdutoPorIdNaoExistente() {
        // Dado um ID de produto que não existe no banco de dados
        val idProdutoNaoExistente = 99

        // Quando fazer uma solicitação GET para o endpoint /produtos/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/produtos/$idProdutoNaoExistente"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

}