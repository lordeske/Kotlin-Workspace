package com.example.pmuproject

import ProfilScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pmuproject.ViewModeli.ProizvodiViewModel
import com.example.pmuproject.ui.theme.PMUProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PMUProjectTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = "proizvodi",
                        modifier = Modifier.padding(padding)  // Apply the padding here
                    ) {
                        composable("proizvodi") {
                            val proizvodiViewModel: ProizvodiViewModel = viewModel()
                            ProizvodiScreen(proizvodiViewModel = proizvodiViewModel)
                        }
                        composable("korpa") { KorpaScreen() }
                        composable("profil") { ProfilScreen() }
                        composable("porudzbine") { PorudzbineScreen() }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Pocetna") },
            label = { Text("Proizvodi") },
            selected = currentDestination?.route == "proizvodi",
            onClick = {
                navController.navigate("proizvodi") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Korpa") },
            label = { Text("Korpa") },
            selected = currentDestination?.route == "korpa",
            onClick = {
                navController.navigate("korpa") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Porudzbine") },
            label = { Text("Porudzbine") },
            selected = currentDestination?.route == "porudzbine",
            onClick = {
                navController.navigate("porudzbine") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Profil") },
            label = { Text("Profil") },
            selected = currentDestination?.route == "profil",
            onClick = {
                navController.navigate("profil") {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}
