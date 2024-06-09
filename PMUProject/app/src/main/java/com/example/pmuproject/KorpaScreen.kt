package com.example.pmuproject

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.example.pmuproject.shop.ProizvodDT

@Composable
fun KorpaScreen(korpa: List<ProizvodDT>, onSadaClick: (ProizvodDT) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(korpa) { proizvod ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp),

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = proizvod.naziv,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Cena: ${proizvod.cena}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Button(
                        onClick = { onSadaClick(proizvod) },
                        modifier = Modifier
                    ) {
                        Text("Ukloni")
                    }
                }
            }
        }
    }
}




@Composable
fun KorpaItem(proizvod: ProizvodDT) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = proizvod.naziv, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Cena: ${proizvod.cena}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Datum dostave: ${proizvod.datumDostave}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
