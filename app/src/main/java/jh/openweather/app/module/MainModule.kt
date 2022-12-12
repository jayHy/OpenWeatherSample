package jh.openweather.app.module

import jh.openweather.app.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// Koin 모듈
val mainModule : Module = module {
    viewModel { MainViewModel() }
}