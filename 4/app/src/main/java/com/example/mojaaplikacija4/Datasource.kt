package com.example.mojaaplikacija4

class Datasource {

fun ucitajResurse() : List<ResursModell>{


    return listOf<ResursModell>(
        ResursModell(R.string.ime_slike, R.drawable.image1),
        ResursModell(R.string.ime_slike2, R.drawable.image2),
        ResursModell(R.string.ime_slike3, R.drawable.image3),
        ResursModell(R.string.ime_slike4, R.drawable.image4),
        ResursModell(R.string.ime_slike5, R.drawable.image5),
        ResursModell(R.string.ime_slike6, R.drawable.image6),
        ResursModell(R.string.ime_slike7, R.drawable.image7),

    )



}


}