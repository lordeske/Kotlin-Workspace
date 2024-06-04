package com.example.pmuproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pmuproject.shop.Datasource
import com.example.pmuproject.shop.Proizvod
import com.example.pmuproject.ui.theme.PMUProjectTheme






//Lista objekata
@Composable
fun ListApp(resourceList: List<Proizvod>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(resourceList) { proizvod ->
            ProizvodItem(
                proizvod = proizvod,
                izmeniClick = { /* Implementiraj logiku za izmenu proizvoda */ },
                dodajUKorpuClick = { /* Implementiraj logiku za dodavanje proizvoda u korpu */ }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}



// Kartica
  @Composable
fun ProizvodItem(
    proizvod: Proizvod,
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

            // Dodaj dugmad "Izmeni" i "Dodaj u korpu" skroz desno
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








/// MAIN
class KorpaActivity : ComponentActivity() {
    private var selectedNavItem by mutableStateOf(1) // Dodaj ovu promenljivu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PMUProjectTheme {
                Scaffold(
                    bottomBar = { BottomNavigationBar(
                        selectedNavItem = selectedNavItem, // Prosledi trenutno selektovanu stavku
                        onClickProizvodi = { /* Akcija za Proizvodi */ },
                        onClickKorpa = { /* Akcija za Korpa */ },
                        onClickProfil = { /* Akcija za Profil */ } )}

                ) { padding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ListApp(resourceList = Datasource.ucitajProizvode())
                    }
                }
            }
        }
    }
}





