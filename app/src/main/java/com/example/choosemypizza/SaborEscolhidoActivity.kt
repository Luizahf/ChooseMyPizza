package com.example.choosemypizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SaborEscolhidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sabor_escolhido)
        this.supportActionBar?.hide()

        val sabor = intent.getIntExtra(R.string.sabor_escolhido.toString(), 0)
        exibirPizza(sabor)
    }

    private fun exibirPizza(sabor: Int) {
        when(sabor) {
            R.drawable.quatro_queijos -> {
                findViewById<TextView>(R.id.titulo).text = "O sabor de hoje será: Quatro Queijos"
                findViewById<ImageView>(R.id.pizza).setImageResource(R.drawable.quatro_queijos)
            }
            R.drawable.calabresa -> {
                findViewById<TextView>(R.id.titulo).text = "O sabor de hoje será: Calabresa"
                findViewById<ImageView>(R.id.pizza).setImageResource(R.drawable.calabresa)
            }
            R.drawable.portuguesa -> {
                findViewById<TextView>(R.id.titulo).text = "O sabor de hoje será: Portuguesa"
                findViewById<ImageView>(R.id.pizza).setImageResource(R.drawable.portuguesa)
            }
            R.drawable.a_moda -> {
                findViewById<TextView>(R.id.titulo).text = "O sabor de hoje será: A Moda"
                findViewById<ImageView>(R.id.pizza).setImageResource(R.drawable.a_moda)
            }
        }
    }
}