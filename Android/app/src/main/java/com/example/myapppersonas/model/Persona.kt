package com.example.myapppersonas.model

import kotlinx.serialization.Serializable

@Serializable
data class Persona(
    val nombre: String,
    val apellido: String,
    val edad: Int
)