package com.example.pmuproject.Klase

import com.example.pmuproject.shop.ProizvodDT

class Datasource {



        fun ucitajProizvode(): List<ProizvodDT> {
            return listOf(
                ProizvodDT(1, "Proizvod 1", 100.0, 20230601),
                ProizvodDT(2, "Proizvod 2", 150.0, 20230602),
                ProizvodDT(3, "Proizvod 3", 200.0, 20230603),
                ProizvodDT(4, "Proizvod 4", 250.0, 20230604),
                ProizvodDT(5, "Proizvod 5", 300.0, 20230605)
            )
        }


}