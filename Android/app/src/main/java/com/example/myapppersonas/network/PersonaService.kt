package com.example.myapppersonas.network

import com.example.myapppersonas.model.Persona
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val BASE_URL =
    "http://10.0.2.2:8080/"

//        "http://10.0.2.2:8080" // esta es la IP del localhost del ordenador


interface PersonaApiService {
    @GET("personas")
    suspend fun getPersonas(): List<Persona>

    @PUT("personas/{id}")
    suspend fun updatePersona(@Path("id") id: Long, @Body persona: Persona): Persona

    @DELETE("personas/{id}")
    suspend fun deletePersona(@Path("id") id: Int): Response<Void>

    @POST("personas")
    suspend fun addPersona(@Body persona: Persona): Response<Void>
}

object PersonaApi {
    val retrofitService: PersonaApiService by lazy {
        retrofit.create(PersonaApiService::class.java)
    }
}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
