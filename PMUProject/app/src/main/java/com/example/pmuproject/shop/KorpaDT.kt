package com.example.pmuproject.shop

class KorpaDT {
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
