package com.example.activitat4projecte

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val date = findViewById<TextView>(R.id.date)
        val username = findViewById<EditText>(R.id.username)
        val btnStart = findViewById<Button>(R.id.btnStart)

        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        date.text = getString(R.string.data_avui, currentDate)

        btnStart.setOnClickListener {
            if (username.text.toString().isNotEmpty()) {
                startActivity(Intent(this, StartActivity::class.java).apply {
                    putExtra("NOM_USUARI", username.text.toString())
                })
            } else {
                username.error = "Error. Nom d'usuari incorrecte."
            }
        }
    }
}