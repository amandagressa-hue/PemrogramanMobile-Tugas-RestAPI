package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData(recyclerView)
    }

    private fun fetchData(recyclerView: RecyclerView) {
        lifecycleScope.launch {
            try {
                // Memanggil API menggunakan Retrofit
                val response = RetrofitClient.instance.getBarang()

                if (response.success && response.data.isNotEmpty()) {
                    val adapter = BarangAdapter(response.data)
                    recyclerView.adapter = adapter
                } else {
                    Toast.makeText(this@MainActivity, "Data kosong", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                Log.e("API_ERROR", "Gagal mengambil data: ${e.message}", e)
                Toast.makeText(
                    this@MainActivity,
                    "Gagal koneksi: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
