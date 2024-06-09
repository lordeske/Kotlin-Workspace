import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfilScreen(profilViewModel: ProfilViewModel = viewModel()) {
    var novoIme by remember { mutableStateOf(TextFieldValue(profilViewModel.ime)) }
    var ime by remember { mutableStateOf(profilViewModel.ime) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.DarkGray // Use a dark color for the background
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Dodaj sliku korisnika
                KorisnickaSlika(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profil",
                    modifier = Modifier.size(120.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Prikaži ime korisnika
                Text(
                    text = "Ime: $ime",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White // Ensure the text color is readable on the dark background
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Polje za unos novog imena
                OutlinedTextField(
                    value = novoIme,
                    onValueChange = { novoIme = it },
                    label = { Text("Novo ime") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Dugme za potvrdu promene imena
                Button(
                    onClick = {
                        ime = novoIme.text
                        profilViewModel.ime = novoIme.text
                        // Ovde možete dodati logiku za čuvanje novog imena u bazi podataka ili slično
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Promeni ime")
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Prikaži broj kupljenih proizvoda
                Text(
                    text = "Ukupno puta porucio: ${profilViewModel.brojKupljenihProizvoda}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White // Ensure the text color is readable on the dark background
                )
            }
        }
    }
}

@Composable
fun KorisnickaSlika(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier
            .clip(CircleShape)
            .padding(4.dp)
            .background(
                color = LocalContentColor.current.copy(alpha = 0.1f),
                shape = CircleShape
            )
    )
}


