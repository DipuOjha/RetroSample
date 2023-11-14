package com.example.retrosample

class repo(var retroService: RetroService) {
    suspend fun getTodosR()=
        retroService.getTodos()


}