package com.example.marvel.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.largeTopAppBarColors(
            titleContentColor = Color(0,0,128),
            containerColor = Color(red = 184, green = 161, blue = 249)
        ),
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    // TODO : Свой текст из ресурсов
                    text = stringResource(R.string.app_name),
                    fontFamily = FontFamily.Cursive,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(90.dp, bottom = 15.dp), // Добавить отступы к тексту

                    fontSize = 50.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    )
}