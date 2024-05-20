package com.example.myapppersonas.model

import kotlinx.serialization.Serializable

@Serializable
data class Escuela(
    val id: Int,
    val nombre: String,
    val especialidad: String,
    val numeroDeCaseta: Int
)