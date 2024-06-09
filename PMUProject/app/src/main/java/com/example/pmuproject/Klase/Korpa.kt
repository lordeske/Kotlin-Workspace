package com.example.pmuproject.Klase

import androidx.compose.runtime.mutableStateListOf
import com.example.pmuproject.shop.ProizvodDT

class Korpa {

    object Korpa {
        private val proizvodi = mutableStateListOf<ProizvodDT>()

        fun dodajProizvod(proizvodDT: ProizvodDT) {
            proizvodi.add(proizvodDT)
        }

        fun izbaciProizvod(proizvodDT: ProizvodDT) {
            proizvodi.remove(proizvodDT)
        }

        fun getProizvodi(): List<ProizvodDT> {
            return proizvodi
        }
    }
}
