package com.example.choosemypizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        setLayoutInicial()
        val btnEscolher = findViewById<Button>(R.id.escolher)
        btnEscolher.setOnClickListener(this)

        MainViewModel.saborEscolhido.observe(this, { sabor ->
            if (sabor != null) {
                val telaSaborEscolhido = Intent(this, SaborEscolhidoActivity::class.java)
                telaSaborEscolhido.putExtra(R.string.sabor_escolhido.toString(), sabor)
                startActivity(telaSaborEscolhido)
            }
        })
    }

    private fun setLayoutInicial() {
        val tituloPagina = findViewById<TextView>(R.id.titulo)
        tituloPagina.text = getString(R.string.titulo_escolha)

        val imgPizza = findViewById<ImageView>(R.id.pizza)
        imgPizza.setImageResource(R.drawable.escolher_pizza)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.escolher -> {
                exibirLoad()
                GlobalScope.launch {
                    MainViewModel.escolherSabor()
                }
            }
        }
    }

    private fun exibirLoad() {
        val imgPizza = findViewById<ImageView>(R.id.pizza)
        imgPizza.animate().rotation(1085F).start()
    }
}