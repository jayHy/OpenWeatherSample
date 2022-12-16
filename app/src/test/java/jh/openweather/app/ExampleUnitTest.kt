package jh.openweather.app

import android.util.Log
import jh.openweather.data.datasource.remote.WeatherDataSourceImpl
import jh.openweather.data.datasource.remote.WeatherRemoteDataSource
import jh.openweather.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.koin.test.inject
import org.koin.test.mock.declareMock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : AbstractKoinTest() {

    private val getWeatherUseCase : GetWeatherUseCase by inject()

    @Before
    fun setup() {

    }

    @Test
    fun getWeatherData() = runBlocking {
//        assertEquals(1, 1)
        val result = getWeatherUseCase.invoke()


//        assertThat(result).isFalse()
//        useCase.invoke()
//        val response = impl.currentWeatherData()
//        Log.d("", response.toString())
    }
}