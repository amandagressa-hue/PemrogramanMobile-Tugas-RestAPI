package com.example.myapplication

import retrofit2.http.GET

interface ApiService {
    @GET("db_imo/barang.php")
    suspend fun getBarang(): ApiResponse
}
