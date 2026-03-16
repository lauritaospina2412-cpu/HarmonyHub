package com.laurabautista.harmonyhub

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val etNombre = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etNombre)
        val etEdad = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.etEdad)
        val spInstrumento = findViewById<MaterialAutoCompleteTextView>(R.id.spInstrumento)
        val cbTerminos = findViewById<MaterialCheckBox>(R.id.cbTerminos)
        val btnEnviar = findViewById<MaterialButton>(R.id.btnEnviar)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        // Configurar el spinner con autocompletado
        val instrumentos = arrayOf("Guitarra", "Piano", "Batería", "Violín", "Bajo", "Ukelele", "Saxofón", "Flauta")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            instrumentos
        )

        spInstrumento.setAdapter(adapter)

        // Botón de retroceso
        btnBack.setOnClickListener {
            finish() // Vuelve a la actividad anterior
        }

        btnEnviar.setOnClickListener {

            val nombre = etNombre.text.toString()
            val edad = etEdad.text.toString()
            val instrumento = spInstrumento.text.toString()

            when {
                nombre.isEmpty() || edad.isEmpty() || instrumento.isEmpty() -> {
                    Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
                !cbTerminos.isChecked -> {
                    Toast.makeText(this, "Debes aceptar los términos", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val intent = Intent(this, ConfirmacionActivity::class.java)
                    intent.putExtra("nombre", nombre)
                    intent.putExtra("edad", edad)
                    intent.putExtra("instrumento", instrumento)
                    startActivity(intent)
                }
            }
        }
    }
}