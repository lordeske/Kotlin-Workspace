package com.example.pmuproject.Klase

import com.example.pmuproject.shop.ProizvodDT

class Datasource {



        fun ucitajProizvode(): List<ProizvodDT> {
            return listOf(
                ProizvodDT(1, "Logitech Mis", 100.0, "2 dana"),
                ProizvodDT(2, "Redragon tastatura", 150.0, "3 dana"),
                ProizvodDT(3, "USB kabal", 200.0, "3 dana"),
                ProizvodDT(4, "Nokia Lumia", 250.0, "2 dana"),
                ProizvodDT(5, "IPhone 69 Pro", 300.0, "4 dana")
            )
        }


}