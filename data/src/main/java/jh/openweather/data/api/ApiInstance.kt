package jh.openweather.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiInstance {

    private const val TIMEOUT = 30L
    private var okHttpClient: OkHttpClient

    private const val BASE_URL = "https://api.openweathermap.org"
    const val APP_ID = "4f2f26a2aa33114ef14cf3720d00255a"

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = OkHttpClient().newBuilder().apply {
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(logging)
        }.build()

    }

    //by lazy 로 늦은 초기화 해줌으로써,
    //api 변수가 사용될 때 초기화되고, 그 안에서 retrofit 변수를 사용하기 때문에 초기화 된다.
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("$BASE_URL/data/2.5/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }

}