package com.example.pmuproject.Klase

import com.example.pmuproject.shop.ProizvodDT

class Korpa {




    object Korpa {
        private val proizvodi = mutableListOf<ProizvodDT>()

        fun dodajProizvod(proizvodDT: ProizvodDT) {
            proizvodi.add(proizvodDT)
        }

        fun izbaciProizvod(proizvodDT: ProizvodDT) {
            proizvodi.remove(proizvodDT)
        }

        fun getProizvodi(): List<ProizvodDT> {
            return proizvodi.toList()
        }
    }


}