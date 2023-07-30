package com.jumarket.system.controller

import com.jumarket.system.entity.CarrinhoDeCompra
import com.jumarket.system.enumeration.FormaPagamento
import com.jumarket.system.service.CarrinhoDeCompraService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carrinhos")
class CarrinhoDeCompraController(private val carrinhoDeCompraService: CarrinhoDeCompraService) {

    @PostMapping
    fun criarCarrinhoDeCompra(@RequestBody carrinhoDeCompra: CarrinhoDeCompra): CarrinhoDeCompra {
        return carrinhoDeCompraService.criarCarrinhoDeCompra(carrinhoDeCompra)
    }

    @GetMapping("/{id}")
    fun buscarCarrinhoDeCompraPorId(@PathVariable id: Long): ResponseEntity<CarrinhoDeCompra> {
        val carrinhoDeCompra = carrinhoDeCompraService.buscarCarrinhoPorId(id)

        return if (carrinhoDeCompra != null) {
            ResponseEntity.ok(carrinhoDeCompra)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun buscarTodosCarrinhosDeCompra(): List<CarrinhoDeCompra> {
        return carrinhoDeCompraService.buscarTodosCarrinhosDeCompra()
    }

    @PostMapping("/{id}/finalizar-compra")
    fun finalizarCompra(
        @PathVariable id: Long,
        @RequestParam valorTotal: Double,
        @RequestParam formaPagamento: FormaPagamento
    ): ResponseEntity<CarrinhoDeCompra> {
        val carrinhoDeCompraFinalizado = carrinhoDeCompraService.finalizarCompra(id, valorTotal, formaPagamento)

        return if (carrinhoDeCompraFinalizado != null) {
            ResponseEntity.ok(carrinhoDeCompraFinalizado)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}