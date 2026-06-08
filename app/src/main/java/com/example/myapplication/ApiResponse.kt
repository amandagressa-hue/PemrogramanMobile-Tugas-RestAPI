package com.example.myapplication

import com.google.gson.annotations.SerializedName

// Data class untuk menampung wrapper JSON dari API dosen
// Struktur JSON: {"success": true, "message": "OK", "data": [ {...}, {...} ]}
data class ApiResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: List<Barang>
)
