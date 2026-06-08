package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvNama = findViewById<TextView>(R.id.tvDetailNama)
        val tvKategori = findViewById<TextView>(R.id.tvDetailKategori)
        val tvStok = findViewById<TextView>(R.id.tvDetailStok)
        val tvHarga = findViewById<TextView>(R.id.tvDetailHarga)
        val tvDeskripsi = findViewById<TextView>(R.id.tvDetailDeskripsi)

        val intent = intent
        tvNama.text = "Nama: ${intent.getStringExtra("nama_barang")}"
        tvKategori.text = "Kategori: ${intent.getStringExtra("kategori")}"
        tvStok.text = "Stok: ${intent.getIntExtra("stok", 0)}"
        tvHarga.text = "Harga: Rp ${intent.getIntExtra("harga", 0)}"
        tvDeskripsi.text = "Deskripsi: ${intent.getStringExtra("deskripsi")}"
    }
}
