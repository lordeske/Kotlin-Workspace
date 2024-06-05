package com.example.pmuproject

import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pmuproject.shop.ProizvodDT
import com.example.pmuproject.Klase.Korpa

@Composable
fun ProizvodiScreen() {
    val proizvodi = Datasource.ucitajProizvode()

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(proizvodi) { proizvod ->
            ProizvodItem(
                proizvod = proizvod,
                izmeniClick = { /* Implementiraj logiku za izmenu proizvoda */ },
                dodajUKorpuClick = { Korpa.Korpa.dodajProizvod(proizvod) }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ProizvodItem(
    proizvod: ProizvodDT,
    izmeniClick: () -> Unit,
    dodajUKorpuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = proizvod.naziv, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Cena: ${proizvod.cena}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Datum dostave: ${proizvod.datumDostave}", style = MaterialTheme.typography.bodySmall)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = izmeniClick,
                    modifier = Modifier
                        .width(100.dp)
                        .height(36.dp)
                ) {
                    Text("Izmeni")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = dodajUKorpuClick,
                    modifier = Modifier
                        .width(100.dp)
                        .height(36.dp)
                ) {
                    Text("Dodaj")
                }
            }
        }
    }
}

object Datasource {
    fun ucitajProizvode(): List<ProizvodDT> {
        return listOf(
            ProizvodDT(1, "Proizvod 1", 100.0, 20230601),
            ProizvodDT(2, "Proizvod 2", 150.0, 20230602)
            // Dodajte još proizvoda po potrebi
        )
    }
}
