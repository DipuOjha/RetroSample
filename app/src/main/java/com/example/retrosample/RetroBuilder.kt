package com.example.retrosample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroBuilder {
    companion object {
        var retroService: RetroService? = null
        fun getRetro(): RetroService? {
            if (retroService == null) {
                retroService = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                    .create(RetroService::class.java)
            }
            return retroService
        }
    }
}