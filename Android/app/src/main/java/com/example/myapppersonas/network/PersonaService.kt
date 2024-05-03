package com.example.myapppersonas.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val BASE_URL =
    "http://10.0.2.2:8080"
//        "http://10.0.2.2:8080" // esta es la IP del localhost del ordenador
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface PersonaService {
    @GET("personas")
    suspend fun getPersonas(): List<Persona>
    @POST("personas")
    suspend fun addPersona(@Body persona: Persona): Persona

    @PUT("personas/{id}")
    suspend fun updatePersona(@Path("id") id: Long, @Body persona: Persona): Persona

    @DELETE("personas/{id}")
    suspend fun deletePersona(@Path("id") id: Long): Unit
}

object PersonaApi {
    val retrofitService: PersonaService by lazy {
        retrofit.create(PersonaService::class.java)
    }
}