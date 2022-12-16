package jh.openweather.domain.usecase

import jh.openweather.domain.model.Weather
import jh.openweather.domain.repository.WeatherRemoteRepository

class GetWeatherUseCase(private val repository: WeatherRemoteRepository) {
    suspend fun invoke() : Weather{
        return repository.currentWeatherData()
    }
}