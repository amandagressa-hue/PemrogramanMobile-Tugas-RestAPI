package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BarangAdapter(private val listBarang: List<Barang>) :
    RecyclerView.Adapter<BarangAdapter.BarangViewHolder>() {

    inner class BarangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNamaBarang)
        val tvHarga: TextView = itemView.findViewById(R.id.tvHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_barang, parent, false)
        return BarangViewHolder(view)
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        val barang = listBarang[position]
        holder.tvNama.text = barang.namaBarang
        holder.tvHarga.text = "Rp ${barang.harga}"

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("id", barang.id)
            intent.putExtra("nama_barang", barang.namaBarang)
            intent.putExtra("kategori", barang.kategori)
            intent.putExtra("stok", barang.stok)
            intent.putExtra("harga", barang.harga)
            intent.putExtra("deskripsi", barang.deskripsi)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listBarang.size
}
