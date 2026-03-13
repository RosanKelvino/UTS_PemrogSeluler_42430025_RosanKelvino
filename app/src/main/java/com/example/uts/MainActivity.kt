package com.example.uts // Ganti sesuai nama package Anda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNamaDosen = findViewById<EditText>(R.id.etNamaDosen)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        // Aksi saat tombol MASUK diklik
        btnMasuk.setOnClickListener {
            val nama = etNamaDosen.text.toString()

            if (nama.isNotEmpty()) {
                // Proses Pindah Halaman menggunakan Intent
                // Pastikan Anda sudah membuat file SecondActivity.kt
                val intentPindah = Intent(this, SecondActivity::class.java)

                // Membawa data teks ke halaman selanjutnya
                intentPindah.putExtra("NAMA_DOSEN", nama)

                // Menjalankan perpindahan halaman
                startActivity(intentPindah)
            } else {
                Toast.makeText(this, "Nama Dosen harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}