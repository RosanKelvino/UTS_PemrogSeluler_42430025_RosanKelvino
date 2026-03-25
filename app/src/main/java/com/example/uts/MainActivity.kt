package com.example.uts 

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

        btnMasuk.setOnClickListener {
            val nama = etNamaDosen.text.toString()

            if (nama.isNotEmpty()) {
                val intentPindah = Intent(this, SecondActivity::class.java)

                intentPindah.putExtra("NAMA_DOSEN", nama)

                startActivity(intentPindah)
            } else {
                Toast.makeText(this, "Nama Dosen harus diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
