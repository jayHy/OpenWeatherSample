package jh.openweather.data.repository.remote

import jh.openweather.data.datasource.remote.WeatherRemoteDataSource
import jh.openweather.domain.model.Weather

import jh.openweather.domain.repository.WeatherRemoteRepository

class WeatherRemoteRepositoryImpl(private val dataSource: WeatherRemoteDataSource) : WeatherRemoteRepository {
    override suspend fun currentWeatherData(lat : Double, lon : Double) : Weather {
        val response = dataSource.currentWeatherData(lat = lat, lon = lon)
        return Weather(
            temp = response.name
        )
    }
}