package com.example.marvel.Navigation

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import java.lang.reflect.Modifier

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    BottomNavigation {
        val selectedButton = remember { mutableStateOf(0) }
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Главная") },
            selected = selectedButton.value == 0,
            onClick = { navController.navigate("home")
                selectedButton.value = 0},
            selectedContentColor = if (selectedButton.value == 0) Color.Red else Color.Blue,
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = "Setting"
                )
            },
            label = { Text(text = "Опции") },
            selected = selectedButton.value == 0,
            onClick = { navController.navigate("settings")
                selectedButton.value = 0},
            selectedContentColor = if (selectedButton.value == 0) Color.Red else Color.Blue
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            label = { Text(text = "Поиск") },
            selected = selectedButton.value == 0,
            onClick = { navController.navigate("search")
                selectedButton.value = 0},
            selectedContentColor = if (selectedButton.value == 0) Color.Red else Color.Blue
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Results"
                )
            },
            label = { Text(text = "Рейтинг") },
            selected = selectedButton.value == 0,
            onClick = { navController.navigate("results")
                selectedButton.value = 0},
            selectedContentColor = if (selectedButton.value == 0) Color.Red else Color.Blue
        )
    }
}