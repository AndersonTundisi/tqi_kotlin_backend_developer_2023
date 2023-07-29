package com.jumarket.system.repository

import com.jumarket.system.entity.CarrinhoDeCompra
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CarrinhoDeCompraRepository : JpaRepository<CarrinhoDeCompra, Long> {

    // Consulta personalizada para buscar carrinhos de compra pelo CPF do cliente
    @Query("SELECT c FROM CarrinhoDeCompra c WHERE c.cpfCliente = :cpfCliente")
    fun findByCpfCliente(cpfCliente: String): List<CarrinhoDeCompra>

}
