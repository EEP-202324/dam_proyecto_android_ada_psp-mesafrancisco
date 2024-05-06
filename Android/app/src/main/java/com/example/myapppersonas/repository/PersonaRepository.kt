package com.example.myapppersonas.repository

import com.example.myapppersonas.model.Persona
import com.example.myapppersonas.network.PersonaApiService

class PersonaRepository(private val personaService: PersonaApiService) {
    suspend fun addPersona(persona: Persona): Boolean {
        val response = personaService.addPersona(persona)
        return response.isSuccessful
    }
}