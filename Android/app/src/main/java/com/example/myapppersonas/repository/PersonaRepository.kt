package com.example.myapppersonas.repository

import com.example.myapppersonas.model.Persona
import com.example.myapppersonas.network.PersonaApiService

class PersonaRepository(private val personaApiService: PersonaApiService) {
    suspend fun addPersona(persona: Persona): Boolean {
        val response = personaApiService.addPersona(persona)
        return response.isSuccessful
    }
}