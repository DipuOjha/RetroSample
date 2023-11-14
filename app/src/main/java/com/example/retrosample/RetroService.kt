package com.example.retrosample

import retrofit2.Response
import retrofit2.http.GET

interface RetroService {
    @GET("/todos")
    suspend fun getTodos(): Response<Todos>
}