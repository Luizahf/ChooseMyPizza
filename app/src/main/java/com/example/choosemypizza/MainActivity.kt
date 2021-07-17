package com.example.choosemypizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        setLayoutInicial()
    }

    private fun setLayoutInicial() {
        val tituloPagina = findViewById<TextView>(R.id.titulo)
        tituloPagina.text = "Choose my Pizza!!"

        val imgPizza = findViewById<ImageView>(R.id.pizza)
        imgPizza.setImageResource(R.drawable.escolher_pizza)
    }
}