package com.jumarket.system.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class CategoriaControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun testBuscarCategoriaPorIdExistente() {
        // Dado um ID de categoria existente
        val idCategoria = 1L

        // Quando fazer uma solicitação GET para o endpoint /categorias/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/categorias/$idCategoria"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(idCategoria))

    }

    @Test
    fun testBuscarCategoriaPorIdNaoExistente() {
        // Dado um ID de categoria que não existe no banco de dados
        val idCategoriaNaoExistente = 99L

        // Quando fazer uma solicitação GET para o endpoint /categorias/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/categorias/$idCategoriaNaoExistente"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

}

