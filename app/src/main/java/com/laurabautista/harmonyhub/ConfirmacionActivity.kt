package com.laurabautista.harmonyhub

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ConfirmacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvEdad = findViewById<TextView>(R.id.tvEdad)
        val tvInstrumento = findViewById<TextView>(R.id.tvInstrumento)
        val btnVolver = findViewById<MaterialButton>(R.id.btnVolver)
        val btnPerfil = findViewById<MaterialButton>(R.id.btnPerfil)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getStringExtra("edad")
        val instrumento = intent.getStringExtra("instrumento")

        tvNombre.text = "Nombre: $nombre"
        tvEdad.text = "Edad: $edad"
        tvInstrumento.text = "Instrumento: $instrumento"

        // Botón para volver al inicio
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // Botón para ir al perfil (funcionalidad futura)
        btnPerfil.setOnClickListener {
            Toast.makeText(this, "Función de perfil próximamente", Toast.LENGTH_SHORT).show()
            // Aquí iría el Intent para abrir el perfil del usuario
            // val intent = Intent(this, PerfilActivity::class.java)
            // startActivity(intent)
        }
    }
}