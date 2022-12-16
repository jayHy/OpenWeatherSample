package jh.openweather.app

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import jh.openweather.app.module.mainModule
import jh.openweather.app.module.viewModelModule
import org.junit.Rule
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito

abstract class AbstractKoinTest : KoinTest {

    inline fun <reified T> mock(): T = Mockito.mock(T::class.java)

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(listOf(mainModule, viewModelModule))
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz -> Mockito.mock(clazz.java)
    }

//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()

}