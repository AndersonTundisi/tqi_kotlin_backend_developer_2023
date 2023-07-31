package com.jumarket.system.controller

import com.jumarket.system.repository.CategoriaRepository
import com.jumarket.system.service.CategoriaService
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
class CategoriaControllerTest {

    @ExtendWith(SpringExtension::class)
    @WebMvcTest(CategoriaController::class)
    class CategoriaControllerTest
    @MockBean
    lateinit var categoriaRepository:  CategoriaRepository
    @MockBean
    lateinit var categoriaService: CategoriaService

    @Test
    fun testBuscarCategoriaPorIdExistente() {
        // Dado um ID de categoria existente
        val idCategoria = 1

        // Quando fazer uma solicitação GET para o endpoint /categoria/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/categoria/$idCategoria"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(idCategoria))

    }

    @Test
    fun testBuscarCategoriaPorIdNaoExistente() {
        // Dado um ID de categoria que não existe no banco de dados
        val idCategoriaNaoExistente = 99

        // Quando fazer uma solicitação GET para o endpoint /categorias/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/categoria/$idCategoriaNaoExistente"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
    }

}

