package jh.openweather.data.api

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherService {

    @GET("weather")
    suspend fun currentWeatherData(
        @QueryMap map: HashMap<String, String>,
    )
}