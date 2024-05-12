package com.example.myapppersonas.network

import com.example.myapppersonas.model.Escuela
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
interface EscuelaApiService {
    @GET("escuelas")
    suspend fun getEscuelas(): List<Escuela>

    @PUT("escuelas/{id}")
    suspend fun updateEscuela(@Path("id") id: Long, @Body escuela: Escuela): Escuela

    @DELETE("escuelas/{id}")
    suspend fun deleteEscuela(@Path("id") id: Long): Unit

    @POST("escuelas")
    suspend fun addEscuela(@Body escuela: Escuela): Response<Void>
}

object EscuelaApi {
    val retrofitService: EscuelaApiService by lazy {
        retrofit.create(EscuelaApiService::class.java)
    }
}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
