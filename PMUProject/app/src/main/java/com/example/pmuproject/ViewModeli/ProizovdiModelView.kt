package com.example.pmuproject.ViewModeli

import androidx.lifecycle.ViewModel
import com.example.pmuproject.Datasource
import com.example.pmuproject.shop.ProizvodDT
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProizvodiViewModel : ViewModel() {
    private val _proizvodi = MutableStateFlow<List<ProizvodDT>>(emptyList())
    val proizvodi: StateFlow<List<ProizvodDT>> = _proizvodi

    init {
        // Učitavanje proizvoda
        _proizvodi.value = Datasource.ucitajProizvode()
    }

    fun izmeniProizvod(izmenjenProizvod: ProizvodDT) {
        _proizvodi.value = _proizvodi.value.map { if (it.id == izmenjenProizvod.id) izmenjenProizvod else it }
    }
}
