package com.jumarket.system.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class ProdutoControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun testBuscarProdutoPorIdExistente() {
        // Dado um ID de produto existente
        val idProduto = 1L

        // Quando fazer uma solicitação GET para o endpoint /produtos/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/produtos/$idProduto"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(idProduto))

    }

    @Test
    fun testBuscarProdutoPorIdNaoExistente() {
        // Dado um ID de produto que não existe no banco de dados
        val idProdutoNaoExistente = 99L

        // Quando fazer uma solicitação GET para o endpoint /produtos/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/produtos/$idProdutoNaoExistente"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

}