package com.example.myapplication

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

        val btnEvaluar = findViewById<Button>(R.id.btnEvaluar)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etAgua = findViewById<EditText>(R.id.etAgua)
        val etFisica = findViewById<EditText>(R.id.etFisica)
        val etSueno = findViewById<EditText>(R.id.etSueno)

        btnEvaluar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val aguaStr = etAgua.text.toString()
            val fisicaStr = etFisica.text.toString()
            val suenoStr = etSueno.text.toString()

            if (nombre.isEmpty() || aguaStr.isEmpty() || fisicaStr.isEmpty() || suenoStr.isEmpty()) {
                Toast.makeText(this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultadosActivity::class.java).apply {
                putExtra("EXTRA_NOMBRE", nombre)
                putExtra("EXTRA_AGUA", aguaStr.toInt())
                putExtra("EXTRA_FISICA", fisicaStr.toInt())
                putExtra("EXTRA_SUENO", suenoStr.toInt())
            }
            startActivity(intent)
        }
    }
}