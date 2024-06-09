package com.example.pmuproject.ViewModeli

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmuproject.Klase.Korpa
import com.example.pmuproject.shop.ProizvodDT
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class KorpaViewModel : ViewModel() {

    private val _korpa = MutableStateFlow<List<ProizvodDT>>(emptyList())
    val korpa: StateFlow<List<ProizvodDT>> = _korpa

    fun dodajUKorpu(proizvod: ProizvodDT) {
        viewModelScope.launch {
            _korpa.value = _korpa.value + proizvod
        }
    }

    fun obrisiIzKorpe(proizvod: ProizvodDT) {
        viewModelScope.launch {
            _korpa.value = _korpa.value - proizvod
        }
    }

    fun ukupnaCena(): Double {
        return _korpa.value.sumOf { it.cena }


    }


    fun ocistiKorpu() {
        viewModelScope.launch {
            _korpa.value = emptyList()
        }
    }

}