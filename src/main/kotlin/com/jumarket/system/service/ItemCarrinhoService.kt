package com.jumarket.system.service

import com.jumarket.system.entity.ItemCarrinho
import com.jumarket.system.entity.Produto
import com.jumarket.system.repository.ItemCarrinhoRepository
import org.springframework.stereotype.Service

@Service
class ItemCarrinhoService(private val itemCarrinhoRepository: ItemCarrinhoRepository) {
    fun findAll(): List<ItemCarrinho> {
        return itemCarrinhoRepository.findAll()
    }

    fun save(itemCarrinho: ItemCarrinho): ItemCarrinho {
        return itemCarrinhoRepository.save(itemCarrinho)
    }

}