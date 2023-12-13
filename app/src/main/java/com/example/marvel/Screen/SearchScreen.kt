package com.example.marvel.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marvel.viewModel.HomeScreenViewModel


@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: HomeScreenViewModel = viewModel()) {
    val dataList by viewModel.dataList.collectAsState()
    val isLoading by remember(viewModel) { viewModel.isLoading }.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    // Отслеживаем индекс текущего события для обновления
    var currentIndex by rememberSaveable { mutableStateOf(0) }

    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(48.dp))
            } else {
                if (dataList.isNotEmpty()) {
                    val currentData = dataList[currentIndex]

                    Text(
                        text = currentData.dog,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp),
                        fontSize = 40.sp,
                        color = Color(0,0,128),
                    )

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        color = Color(227,217,255), //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "Страна происхождения:",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = currentData.country,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Рост в холке:",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = currentData.height,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Вес:",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = currentData.weight,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Продолжтельность жизни:",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = currentData.life,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Button(
                            onClick = {
                                // Увеличиваем индекс на 1 и обрабатываем переполнение
                                currentIndex = (currentIndex + 1) % dataList.size

                                // Получаем следующее событие для обновления
                                val nextData = dataList[currentIndex].copy(dog = "Новое название фильма")
                                viewModel.updateData(nextData)
                            }
                        ) {
                            Text(text = "Обновить", fontWeight = FontWeight.Bold)
                        }

                        Button(
                            onClick = {
                                viewModel.deleteData(currentData)
                            }
                        ) {
                            Text(text = "Удалить", fontWeight = FontWeight.Bold)
                        }
                    }
                } else {
                    Text(
                        text = "Нет доступных данных",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
}