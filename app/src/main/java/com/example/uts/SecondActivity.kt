package com.example.uts 

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val etJumlahMahasiswa = findViewById<EditText>(R.id.etJumlahMahasiswa)
        val etRataNilai = findViewById<EditText>(R.id.etRataNilai)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvStatusKelas = findViewById<TextView>(R.id.tvStatusKelas)
        val layoutDaftarAbsen = findViewById<LinearLayout>(R.id.layoutDaftarAbsen)
        val namaDosen = intent.getStringExtra("NAMA_DOSEN") ?: "Tanpa Nama"

        tvSapaan.text = "Selamat bertugas, Dosen $namaDosen"

        btnProses.setOnClickListener {
            val jumlahStr = etJumlahMahasiswa.text.toString()
            val rataStr = etRataNilai.text.toString()

            if (jumlahStr.isNotEmpty() && rataStr.isNotEmpty()) {
                val jumlah = jumlahStr.toInt()
                val rata = rataStr.toDouble()

                val status = if (rata >= 80) {
                    "Sangat Baik"
                } else if (rata >= 60) {
                    "Cukup"
                } else {
                    "Kurang"
                }
                tvStatusKelas.text = "Status Kelas: $status"

                val layoutDaftarAbsen = findViewById<LinearLayout>(R.id.layoutDaftarAbsen)
                layoutDaftarAbsen.removeAllViews()

                val judul = TextView(this)
                judul.text = "Daftar Absensi Mahasiswa"
                judul.textSize = 18f
                judul.setTypeface(null, android.graphics.Typeface.BOLD)
                layoutDaftarAbsen.addView(judul)

                for (i in 1..jumlah) {
                    val inputNama = EditText(this)
                    inputNama.hint = "Mahasiswa $i"
                    layoutDaftarAbsen.addView(inputNama)
                }

            } else {
                Toast.makeText(this, "Mohon isi semua data angka!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
