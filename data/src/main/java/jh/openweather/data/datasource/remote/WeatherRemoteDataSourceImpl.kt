package jh.openweather.data.datasource.remote

import jh.openweather.data.api.ApiInstance
import jh.openweather.data.api.ApiInstance.APP_ID
import jh.openweather.data.model.remote.WeatherResponse

interface WeatherRemoteDataSource {
    suspend fun currentWeatherData() : WeatherResponse
}

class WeatherDataSourceImpl(private val apiInstance : ApiInstance) : WeatherRemoteDataSource {
    override suspend fun currentWeatherData() : WeatherResponse {
        return apiInstance.API.currentWeatherData(baseWeatherMap())
    }
}

fun baseWeatherMap() : HashMap<String, String> {
    val map: HashMap<String, String> = HashMap()
    map["appid"] = APP_ID
    map["lang"] = "kr"
    map["lon"] = "10.99"
    map["lat"] = "44.34"
    return map
}