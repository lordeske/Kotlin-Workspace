package com.example.pmuproject.Klase

import com.example.pmuproject.shop.Proizvod

class Korpa {




    object Korpa {
        private val proizvodi = mutableListOf<Proizvod>()

        fun dodajProizvod(proizvod: Proizvod) {
            proizvodi.add(proizvod)
        }

        fun izbaciProizvod(proizvod: Proizvod) {
            proizvodi.remove(proizvod)
        }

        fun getProizvodi(): List<Proizvod> {
            return proizvodi.toList()
        }
    }


}