package com.example.marvel.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.marvel.AboutAppScreen
import com.example.marvel.Screen.HomeScreen
import com.example.marvel.Screen.InfoScreen
import com.example.marvel.Screen.SettingsScreen
import com.example.marvel.Screen.SearchScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = "aboutApp") {
        composable("aboutApp") { AboutAppScreen() }
        composable("home") { HomeScreen(navController) }
        composable("settings") { SettingsScreen() }
        composable("search") { SearchScreen() }
        composable("info") { InfoScreen() }
    }
}