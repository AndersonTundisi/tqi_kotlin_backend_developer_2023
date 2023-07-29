package com.jumarket.system.entity

import jakarta.persistence.*

@Entity
data class Categoria(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(nullable = false) val nome: String
)
