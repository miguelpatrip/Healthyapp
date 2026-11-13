package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvPorcentaje = findViewById<TextView>(R.id.tvPorcentaje)
        val tvMensaje = findViewById<TextView>(R.id.tvMensaje)
        val btnReintentar = findViewById<Button>(R.id.btnReintentar)
        val btnConsejos = findViewById<Button>(R.id.btnConsejos)

        val nombre = intent.getStringExtra("EXTRA_NOMBRE") ?: "Usuario"
        val agua = intent.getIntExtra("EXTRA_AGUA", 0)
        val fisica = intent.getIntExtra("EXTRA_FISICA", 0)
        val sueno = intent.getIntExtra("EXTRA_SUENO", 0)

        var metasCumplidas = 0
        val faltaAgua = agua < 8
        val faltaFisica = fisica < 30
        val faltaSueno = sueno < 8

        if (!faltaAgua) metasCumplidas++
        if (!faltaFisica) metasCumplidas++
        if (!faltaSueno) metasCumplidas++

        val porcentaje = (metasCumplidas.toDouble() / 3.0) * 100

        val mensaje = when (metasCumplidas) {
            3 -> "Excelente: ¡Felicitaciones! Cumpliste todas tus metas."
            2 -> "Bueno: ¡Buen trabajo! Estás cerca de completar tus metas."
            1 -> "Regular: Puedes mejorar tus hábitos diarios."
            else -> "Bajo: Intenta organizar mejor tus hábitos."
        }

        tvNombre.text = "Hola, $nombre"
        tvPorcentaje.text = "Cumplimiento: ${porcentaje.toInt()}%"
        tvMensaje.text = mensaje

        btnReintentar.setOnClickListener { finish() }

        btnConsejos.setOnClickListener {
            val intentConsejos = Intent(this, ConsejosActivity::class.java).apply {
                putExtra("FALTA_AGUA", faltaAgua)
                putExtra("FALTA_FISICA", faltaFisica)
                putExtra("FALTA_SUENO", faltaSueno)
            }
            startActivity(intentConsejos)
        }
    }
}