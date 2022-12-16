package jh.openweather.app.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jh.openweather.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getWeatherUseCase : GetWeatherUseCase) : ViewModel() {

    fun getWeather() {
        viewModelScope.launch {
            val res = getWeatherUseCase.invoke()
        }
    }
}