package jh.openweather.domain.usecase

import jh.openweather.domain.model.Weather
import jh.openweather.domain.repository.WeatherRemoteRepository

class GetWeatherUseCase(private val repository: WeatherRemoteRepository) {
    suspend fun invoke(lat : Double, lon: Double) : Weather {
        return repository.currentWeatherData(lat = lat, lon = lon)
    }
}