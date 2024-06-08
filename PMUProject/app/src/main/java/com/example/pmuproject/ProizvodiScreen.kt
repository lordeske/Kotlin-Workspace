package com.example.pmuproject

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pmuproject.shop.ProizvodDT


@Composable
fun ProizvodiScreen(proizvodiViewModel: ProizvodiViewModel = viewModel()) {
    val proizvodi by proizvodiViewModel.proizvodi.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(proizvodi) { proizvod ->
            ProizvodItem(
                proizvod = proizvod,
                izmeniClick = { /* Implementiraj logiku za izmenu proizvoda */ },
                sacuvajIzmeneClick = { izmenjenProizvod ->
                    proizvodiViewModel.izmeniProizvod(izmenjenProizvod)
                },
                dodajUKorpuClick = { Korpa.dodajProizvod(proizvod) }
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
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
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
            ProizvodDT(3, "Proizvod 3", 200.0, 20230603),
            ProizvodDT(4, "Proizvod 4", 250.0, 20230604),
            ProizvodDT(5, "Proizvod 5", 300.0, 20230605)
        )
    }
}

object Korpa {
    private val korpa = mutableListOf<ProizvodDT>()

    fun dodajProizvod(proizvod: ProizvodDT) {
        korpa.add(proizvod)
    }

    fun getProizvodi(): List<ProizvodDT> {
        return korpa
    }
}
