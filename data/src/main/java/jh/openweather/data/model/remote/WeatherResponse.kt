package jh.openweather.data.model.remote

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String, // 도시 이름
    @SerializedName("cod")
    val cod : Int,
    @SerializedName("timezone")
    val timezone : Int,
    @SerializedName("base")
    val base : String,
    @SerializedName("visibility")
    val visibility : Int,
    @SerializedName("dt")
    val dt : Long,

    @SerializedName("weather")
    val weathers : List<Weather>?,

    @SerializedName("main")
    val main : Main,

    @SerializedName("wind")
    val wind: Wind,

    @SerializedName("rain")
    val rain : Rain,

    @SerializedName("snow")
    val snow : Snow,

    @SerializedName("clouds")
    val clouds: Clouds,

    @SerializedName("coord")
    val coord : Coord,

    @SerializedName("sys")
    val sys : Sys
)

data class Weather(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main : String, // 날씨 (비, 눈 등)
    @SerializedName("description")
    val description : String, // 날씨 설명
    @SerializedName("icon")
    val icon : String
)

data class Main(
    @SerializedName("temp")
    val temp : Float, // 온도
    @SerializedName("feels_like")
    val feels_like : Float, // 체감 온도
    @SerializedName("temp_min")
    val temp_min : Float, // 최저 기온
    @SerializedName("temp_max")
    val temp_max : Float, // 최고 기온
    @SerializedName("pressure")
    val pressure : Float, // 기압
    @SerializedName("humidity")
    val humidity : Float, // 습도
    @SerializedName("sea_level")
    val sea_level : Float, // 바다 기압
    @SerializedName("grnd_level")
    val grnd_level : Float, // 지상 기압
)

data class Wind(
    @SerializedName("speed")
    val speed : Float, // 풍속
    @SerializedName("deg")
    val deg : Float, // 풍향
    @SerializedName("gust")
    val gust : Float // 바람 세기
)

data class Rain(
    @SerializedName("1h")
    val hour1 : Float // 이전 1시간 강수량
)

data class Snow(
    @SerializedName("1h")
    val hour1 : Float // 이전 1시간 적설량
)

data class Clouds(
    @SerializedName("all")
    val all : Int // 구름 (%)
)

data class Coord(
    @SerializedName("lon")
    val lon : Float,
    @SerializedName("lat")
    val lat : Float,
)

data class Sys(
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type : Int,
    @SerializedName("country")
    val country : String,
    @SerializedName("sunrise")
    val sunrise : Int, // 일출 (UTC)
    @SerializedName("sunset")
    val sunset : Int // 일몰 (UTC)
)
