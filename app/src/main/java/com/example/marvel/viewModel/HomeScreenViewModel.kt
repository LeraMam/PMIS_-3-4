package com.example.marvel.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class Data(val id: Int, val country: String, val dog: String, val weight : String, val height: String, val life : String,) {

}
class HomeScreenViewModel : ViewModel() {
    private val _dataList = MutableStateFlow<List<Data>>(emptyList())
    val dataList: StateFlow<List<Data>> = _dataList
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    // Загрузка данных
    fun loadData() {
        // Используйте корутины для выполнения асинхронной загрузки данных
        viewModelScope.launch(Dispatchers.IO) {
            // Симуляция загрузки данных
            _isLoading.emit(true)
            delay(2000)
            val loadedData = listOf(
                Data(1, "Великобритания", "Золотистый ретривер", "Кобели 26-41 кг, Суки 25-37 кг", "Кобели 56-61 см, Суки 51-56 см", "12-13 лет"),
                Data(2, "Германия", "Немецкий шпиц", "В среднем 1,4-3,2 кг", "В среднем 18-22 см", "12-16 лет"),
                Data(3, "Великобритания", "Корги", "В среднем 9-13 кг", "В среднем 25-30 см", "9-12 лет"),
                Data(4, "Германия", "Ротвейлер", "Кобели ~50 кг, Суки ~45 кг", "Кобели 61-70 см, Суки 56-65 см", "11-12 лет"),
                Data(5, "Германия", "Доберман", "Кобели: 40-45 кг. Суки: 32-35 кг", "Кобели: 68-72 см. Суки: 63-68 см", "10-14 лет"),
                Data(6, "Германия", "Такса", "В среднем до 12 кг", "В среднем до 35 см", "10-13 лет"),
            )
            _dataList.emit(loadedData)
            _isLoading.emit(false)
        }
    }

    // Обновление данных
    fun updateData(data: Data) {
        viewModelScope.launch(Dispatchers.IO) {
            _dataList.value = _dataList.value.map { existingData ->
                if (existingData.dog == data.dog) {
                    // Обновляем поля в объекте Data
                    existingData.copy(dog = data.dog, weight = data.weight, height = data.height, country = data.country)
                } else {
                    existingData
                }
            }
        }
    }

    // Удаление данных
    fun deleteData(data: Data) {
        viewModelScope.launch(Dispatchers.IO) {
            _dataList.value = _dataList.value.filter { existingData ->
                existingData.dog != data.dog
            }
        }
    }
}