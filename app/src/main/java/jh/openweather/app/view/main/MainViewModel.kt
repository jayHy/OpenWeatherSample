package jh.openweather.app.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import jh.openweather.app.DispatcherProvider
import jh.openweather.app.view.BaseViewModel
import jh.openweather.domain.model.Weather
import jh.openweather.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber

class MainViewModel(
    dispatcherProvider: DispatcherProvider,
    private val getWeatherUseCase : GetWeatherUseCase) : BaseViewModel(dispatcherProvider) {

    private val _weatherLiveData : MutableLiveData<Weather> = MutableLiveData()
    val weatherLiveData : LiveData<Weather> get() = _weatherLiveData

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.d("%s", throwable.toString())
    }

    fun getWeather(lat: Double, lon: Double) {

        onIO(coroutineExceptionHandler) {
            getWeatherUseCase.invoke(lat = lat, lon = lon)
        }

        onMain {

        }

//

    }


}