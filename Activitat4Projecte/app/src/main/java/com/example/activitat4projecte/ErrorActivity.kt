package com.example.activitat4projecte

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val resultat: TextView = findViewById(R.id.result)
        val btnBack: Button = findViewById(R.id.btnBack)

        val nomUsuari = intent.getStringExtra("NOM_USUARI") ?: "Usuari"
        val numIntroduit = intent.getIntExtra("NUMERO_INTRODUIT", 0)
        val numSecret = intent.getIntExtra("NUMERO_SECRET", 0)

        resultat.text = getString(R.string.fail_message, nomUsuari, numIntroduit, numSecret)

        btnBack.setOnClickListener { finish() }
    }
}
