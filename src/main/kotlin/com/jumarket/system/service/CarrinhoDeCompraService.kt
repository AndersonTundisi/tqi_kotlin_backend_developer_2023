package com.jumarket.system.service

import com.jumarket.system.repository.CarrinhoDeCompraRepository
import com.jumarket.system.entity.CarrinhoDeCompra
import com.jumarket.system.entity.Produto
import com.jumarket.system.enumeration.FormaPagamento
import org.springframework.stereotype.Service

@Service
class CarrinhoDeCompraService(private val carrinhoDeCompraRepository: CarrinhoDeCompraRepository) {

    fun criarCarrinhoDeCompra(carrinho: CarrinhoDeCompra): CarrinhoDeCompra {
        return carrinhoDeCompraRepository.save(carrinho)
    }

    fun buscarCarrinhoPorId(id: Long): CarrinhoDeCompra? {
        return carrinhoDeCompraRepository.findById(id).orElse(null)
    }

    fun buscarTodosCarrinhosDeCompra(): List<CarrinhoDeCompra> {
        return carrinhoDeCompraRepository.findAll()
    }

    fun finalizarCompra(id: Long, valorTotal: Double, formaPagamento: FormaPagamento): CarrinhoDeCompra? {
        val carrinho = carrinhoDeCompraRepository.findById(id).orElse(null)

        if (carrinho == null) {
            return null
        }

        carrinho.valorTotalItens = carrinho.calcularValorTotalItens()
        carrinho.formaPagamento = formaPagamento

        return carrinhoDeCompraRepository.save(carrinho)
    }

}