package com.laurabautista.harmonyhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEntrar = findViewById<MaterialButton>(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }

        // Opcional: Agregar funcionalidad al texto "Inicia sesión"
        val tvLogin = findViewById<TextView>(R.id.tvLogin)
        tvLogin?.setOnClickListener {
            // Aquí iría la lógica para ir a login
            // Toast.makeText(this, "Función de login próximamente", Toast.LENGTH_SHORT).show()
        }
    }
}