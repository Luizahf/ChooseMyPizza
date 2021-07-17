package com.example.choosemypizza

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


object SaboresRepositorio {
    suspend fun escolherSabor() : Int {
        val quatro_queijos = R.drawable.quatro_queijos
        val calabresa = R.drawable.calabresa
        val aModa = R.drawable.a_moda
        val portuguesa = R.drawable.portuguesa

        val sabores = mutableListOf(quatro_queijos, calabresa, aModa, portuguesa)
        val task = GlobalScope.async { sabores.random() }
        return task.await()
    }
}