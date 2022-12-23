package jh.openweather.domain.repository

import jh.openweather.domain.model.Weather

interface WeatherRemoteRepository {
    suspend fun currentWeatherData(lat : Double, lon: Double) : Weather
}