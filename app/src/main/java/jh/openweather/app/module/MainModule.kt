package jh.openweather.app.module

import jh.openweather.app.DispatcherProvider
import jh.openweather.app.DispatcherProviderImpl
import jh.openweather.app.view.BaseViewModel
import jh.openweather.app.view.main.MainViewModel
import jh.openweather.data.api.ApiInstance
import jh.openweather.data.datasource.remote.WeatherDataSourceImpl
import jh.openweather.data.datasource.remote.WeatherRemoteDataSource
import jh.openweather.data.repository.remote.WeatherRemoteRepositoryImpl
import jh.openweather.domain.repository.WeatherRemoteRepository
import jh.openweather.domain.usecase.GetWeatherUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// Koin 모듈
val mainModule : Module = module {

    single { ApiInstance }

    single<WeatherRemoteRepository> { WeatherRemoteRepositoryImpl(get())}
    single<WeatherRemoteDataSource> { WeatherDataSourceImpl(get()) }

    factory { GetWeatherUseCase(get()) }

    single<DispatcherProvider> { DispatcherProviderImpl() }



}