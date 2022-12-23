package jh.openweather.app.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jh.openweather.app.DispatcherProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

open class BaseViewModel(
    dispatcherProvider: DispatcherProvider
) : ViewModel(), DispatcherProvider by dispatcherProvider {

    inline fun BaseViewModel.onMain(
        coroutineExceptionHandler : CoroutineExceptionHandler, crossinline body : suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(main) {
        body(this)
    }

    inline fun BaseViewModel.onIO(
        coroutineExceptionHandler : CoroutineExceptionHandler, crossinline body : suspend CoroutineScope.() -> Unit,
    ) = viewModelScope.launch(io + coroutineExceptionHandler) {
        body(this)
    }
    inline fun BaseViewModel.onDefault(
        coroutineExceptionHandler : CoroutineExceptionHandler, crossinline body : suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(default) {
        body(this)
    }

}



