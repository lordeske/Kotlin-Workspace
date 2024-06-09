package com.example.pmuproject

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pmuproject.Klase.Korpa
import com.example.pmuproject.ViewModeli.KorpaViewModel
import com.example.pmuproject.ViewModeli.ProizvodiViewModel
import com.example.pmuproject.shop.ProizvodDT

@Composable
fun ProizvodiScreen(
    proizvodiViewModel: ProizvodiViewModel = viewModel(),
    korpaViewModel: KorpaViewModel = viewModel()
) {
    val proizvodi by proizvodiViewModel.proizvodi.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(proizvodi) { proizvod ->
            ProizvodItem(
                proizvod = proizvod,
                izmeniClick = { /* Implementiraj logiku za izmenu proizvoda */ },
                sacuvajIzmeneClick = { izmenjenProizvod ->
                    proizvodiViewModel.izmeniProizvod(izmenjenProizvod)
                },
                dodajUKorpuClick = {
                    korpaViewModel.dodajUKorpu(proizvod)
                }
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
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (izmena) {
                TextField(
                    value = naziv,
                    onValueChange = { naziv = it },
                    label = { Text("Naziv") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = cena,
                    onValueChange = { cena = it },
                    label = { Text("Cena") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = datumDostave,
                    onValueChange = { datumDostave = it },
                    label = { Text("Vreme dostave") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
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
                                    datumDostave.toString()
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text("Sačuvaj", color = MaterialTheme.colorScheme.onPrimary)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { izmena = false },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text("Odustani", color = MaterialTheme.colorScheme.onSecondary)
                    }
                }
            } else {
                Text(text = proizvod.naziv, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Cena: ${proizvod.cena} RSD", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Dostava traje: ${proizvod.datumDostave}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            izmena = true
                            izmeniClick()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text("Izmeni", color = MaterialTheme.colorScheme.onPrimary)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = dodajUKorpuClick,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Text("Dodaj", color = MaterialTheme.colorScheme.onSecondary)
                    }
                }
            }
        }
    }
}

