package com.example.activitat4projecte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val numero: EditText = findViewById(R.id.number)
        val btnGuess: Button = findViewById(R.id.btnGuess)
        val btnBack: Button = findViewById(R.id.btnBack)
        val enunciatText: TextView = findViewById(R.id.enunciat)
        val nomUsuari = intent.getStringExtra("NOM_USUARI")

        enunciatText.text = getString(R.string.enunciat, nomUsuari)

        btnGuess.setOnClickListener {
            val numIntroduit = numero.text.toString().toIntOrNull()
            if (numIntroduit != null) {
                if (numIntroduit !in 1..3) {
                    numero.error = getString(R.string.num_fora_de_rang)
                } else {
                    val numSecret = Random.nextInt(1, 4)
                    val targetActivity =
                        if (numIntroduit == numSecret) SuccessActivity::class.java
                        else ErrorActivity::class.java
                    startActivity(Intent(this, targetActivity).apply {
                        putExtra("NUMERO_INTRODUIT", numIntroduit)
                        putExtra("NUMERO_SECRET", numSecret)
                        putExtra("NOM_USUARI", nomUsuari)
                    })
                }
            } else {
                numero.error = getString(R.string.numero_invalid)
            }
        }
        btnBack.setOnClickListener { finish() }
    }
}


