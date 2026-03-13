package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menyambungkan file Kotlin ini dengan desain XML activity_login
        setContentView(R.layout.activity_login)

        // 1. Mengenali komponen dari XML berdasarkan ID-nya
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 2. Memberikan aksi saat tombol LOGIN diklik
        btnLogin.setOnClickListener {
            // Mengambil teks yang diketik oleh pengguna
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // 3. Logika pengecekan sederhana
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Pesan sukses bawaan Anda
                Toast.makeText(this, "Login berhasil! Halo, $username", Toast.LENGTH_SHORT).show()

                // TAMBAHKAN KODE INI UNTUK PINDAH HALAMAN
                val intentPindah = Intent(this, SecondActivity::class.java)
                intentPindah.putExtra("NAMA_DOSEN", username) // Membawa username untuk sapaan
                startActivity(intentPindah)

            } else {
                // ... kode Toast gagal Anda
            }
        }
    }
}