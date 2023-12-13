package com.example.marvel.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marvel.MatchResult

@Composable
fun InfoScreen() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        MatchResult("Немецкий шпиц", 190, "Корги", 170)
        MatchResult("Корги", 170, "Ротвейлер", 157)
        MatchResult("Ротвейлер", 157, "Доберман", 150)
        MatchResult("Доберман", 150, "Такса", 113)
        MatchResult("Такса", 113, "Золотистый ретривер", 209)
        MatchResult("Золотистый ретривер", 209, "Корги", 170)
        MatchResult("Корги", 170, "Доберман", 150)
        MatchResult("Ротвейлер", 157, "Немецкий шпиц", 190)
        MatchResult("Немецкий шпиц", 190, "Такса", 113)
    }
}