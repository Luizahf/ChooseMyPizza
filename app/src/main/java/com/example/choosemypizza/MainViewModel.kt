package com.example.choosemypizza

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

object MainViewModel {
    private var saborEscolhidoPrivate : MutableLiveData<Int> = MutableLiveData()
    val saborEscolhido : LiveData<Int> get() = saborEscolhidoPrivate

    suspend fun escolherSabor() {
        val task = GlobalScope.async {
            SaboresRepositorio.escolherSabor()
        }

        saborEscolhidoPrivate.postValue(task.await())
    }
}