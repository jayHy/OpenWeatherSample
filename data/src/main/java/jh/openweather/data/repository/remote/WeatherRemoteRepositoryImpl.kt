package jh.openweather.data.repository.remote

import jh.openweather.data.datasource.remote.WeatherRemoteDataSource
import jh.openweather.domain.model.Weather

import jh.openweather.domain.repository.WeatherRemoteRepository

class WeatherRemoteRepositoryImpl(private val dataSource: WeatherRemoteDataSource) : WeatherRemoteRepository {
    override suspend fun currentWeatherData() : Weather {
        val response = dataSource.currentWeatherData()
        return Weather(
            temp = response.name
        )
    }
}