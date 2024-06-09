package com.example.pmuproject.ViewModeli

import androidx.lifecycle.ViewModel
import com.example.pmuproject.Klase.Datasource
import com.example.pmuproject.shop.ProizvodDT
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProizvodiViewModel : ViewModel() {
    private val _proizvodi = MutableStateFlow<List<ProizvodDT>>(emptyList())
    val proizvodi: StateFlow<List<ProizvodDT>> = _proizvodi

    init {
        // Instanciranje Datasource klase
        val datasource = Datasource()
        // Učitavanje proizvoda
        _proizvodi.value = datasource.ucitajProizvode()
    }

    fun izmeniProizvod(izmenjenProizvod: ProizvodDT) {
        _proizvodi.value = _proizvodi.value.map { if (it.id == izmenjenProizvod.id) izmenjenProizvod else it }
    }
}
