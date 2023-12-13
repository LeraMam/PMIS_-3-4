package com.example.marvel.Screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvel.Items.SettingItem

@Composable
fun SettingsScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text = "Настройки",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        item {
            SettingItem(
                icon = Icons.Default.AccountBox,
                title = "Профиль",
                onClick = { /* Обработчик нажатия */ }
            )
        }

        item {
            SettingItem(
                icon = Icons.Default.DateRange,
                title = "Уведомления",
                onClick = { /* Обработчик нажатия */ }
            )
        }

        item {
            SettingItem(
                icon = Icons.Default.Favorite,
                title = "Любимые породы",
                onClick = { /* Обработчик нажатия */ }
            )
        }


        item {
            SettingItem(
                icon = Icons.Default.Place,
                title = "Карта выгула",
                onClick = { /* Обработчик нажатия */ }
            )
        }

        item {
            SettingItem(
                icon = Icons.Default.Share,
                title = "Поделиться",
                onClick = { /* Обработчик нажатия */ }
            )
        }

        item {
            SettingItem(
                icon = Icons.Default.Lock,
                title = "Пароли и безопасность",
                onClick = { /* Обработчик нажатия */ }
            )
        }

        item {
            SettingItem(
                icon = Icons.Default.Settings,
                title = "Настройки",
                onClick = { /* Обработчик нажатия */ }
            )
        }
    }
}