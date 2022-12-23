package jh.openweather.data.datasource.remote

import jh.openweather.data.api.ApiInstance
import jh.openweather.data.api.ApiInstance.APP_ID
import jh.openweather.data.model.remote.WeatherResponse

interface WeatherRemoteDataSource {
    suspend fun currentWeatherData(lat : Double, lon : Double) : WeatherResponse
}

class WeatherDataSourceImpl(private val apiInstance : ApiInstance) : WeatherRemoteDataSource {
    override suspend fun currentWeatherData(lat : Double, lon : Double) : WeatherResponse {
        val baseMap = baseWeatherMap()
        baseMap["lat"] = lat
        baseMap["lon"] = lon
        return apiInstance.API.currentWeatherData(baseMap)
    }
}

fun baseWeatherMap() : HashMap<String, Any> {
    val map: HashMap<String, Any> = HashMap()
    map["appid"] = APP_ID
    map["lang"] = "kr"
    return map
}