package com.jumarket.system.service

import com.jumarket.system.entity.Categoria
import com.jumarket.system.repository.CategoriaRepository
import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import java.util.*

class CategoriaServiceTest {

@Mock
private lateinit var categoriaRepository: CategoriaRepository

@InjectMocks
private lateinit var categoriaService: CategoriaService

@Test
fun testBuscarCategoriaPorIdExistente() {
    // Dado um id de categoria existente
    val idCategoria = 1L
    val categoriaExistente = Categoria(id = idCategoria, nome = "Eletrônicos")
    `when`(categoriaRepository.findById(idCategoria)).thenReturn(Optional.of(categoriaExistente))

    // Quando buscar a categoria pelo id
    val categoriaEncontrada = categoriaService.buscarCategoriaPorId(idCategoria)

    // Então a categoria deve ser encontrada e os atributos devem ser iguais
    assertNotNull(categoriaEncontrada)
    assertEquals(categoriaExistente.id, categoriaEncontrada?.id)
    assertEquals(categoriaExistente.nome, categoriaEncontrada?.nome)
}

@Test
fun testBuscarCategoriaPorIdNaoExistente() {
    // Dado um id de categoria não existente
    val idCategoria = 99L
    `when`(categoriaRepository.findById(idCategoria)).thenReturn(Optional.empty())

    // Quando buscar a categoria pelo id
    val categoriaEncontrada = categoriaService.buscarCategoriaPorId(idCategoria)

    // Então a categoria não deve ser encontrada (deve ser nula)
    assertNull(categoriaEncontrada)
}

}