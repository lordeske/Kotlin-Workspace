package com.example.pmuproject


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pmuproject.shop.ProizvodDT

@Composable
fun ProizvodiScreen() {
    var proizvodi by remember { mutableStateOf(Datasource.ucitajProizvode()) }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(proizvodi) { proizvod ->
            ProizvodItem(
                proizvod = proizvod,
                izmeniClick = { /* Implementiraj logiku za izmenu proizvoda */ },
                sacuvajIzmeneClick = { izmenjenProizvod ->
                    proizvodi = proizvodi.map { if (it.id == izmenjenProizvod.id) izmenjenProizvod else it }
                },
                dodajUKorpuClick = {  }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}



@Composable
fun ProizvodItem(
    proizvod: ProizvodDT,
    izmeniClick: () -> Unit,
    sacuvajIzmeneClick: (ProizvodDT) -> Unit,
    dodajUKorpuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var izmena by remember { mutableStateOf(false) }
    var naziv by remember { mutableStateOf(proizvod.naziv) }
    var cena by remember { mutableStateOf(proizvod.cena.toString()) }
    var datumDostave by remember { mutableStateOf(proizvod.datumDostave.toString()) }

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            if (izmena) {
                TextField(
                    value = naziv,
                    onValueChange = { naziv = it },
                    label = { Text("Naziv") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = cena,
                    onValueChange = { cena = it },
                    label = { Text("Cena") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                TextField(
                    value = datumDostave,
                    onValueChange = { datumDostave = it },
                    label = { Text("Datum dostave") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            izmena = false
                            sacuvajIzmeneClick(
                                ProizvodDT(
                                    proizvod.id,
                                    naziv,
                                    cena.toDouble(),
                                    datumDostave.toInt()
                                )
                            )
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(36.dp)
                    ) {
                        Text("Sačuvaj")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { izmena = false },
                        modifier = Modifier
                            .width(100.dp)
                            .height(36.dp)
                    ) {
                        Text("Odustani")
                    }
                }
            } else {
                Text(text = proizvod.naziv, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Cena: ${proizvod.cena}", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Datum dostave: ${proizvod.datumDostave}", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            izmena = true
                            izmeniClick()
                        },
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
}


object Datasource {
    fun ucitajProizvode(): List<ProizvodDT> {
        return listOf(
            ProizvodDT(1, "Proizvod 1", 100.0, 20230601),
            ProizvodDT(2, "Proizvod 2", 150.0, 20230602),
            ProizvodDT(3, "Proizvod 2", 150.0, 20230602),
            ProizvodDT(4, "Proizvod 2", 150.0, 20230602),
            ProizvodDT(5, "Proizvod 2", 150.0, 20230602)

            // Dodajte još proizvoda po potrebi
        )
    }
}