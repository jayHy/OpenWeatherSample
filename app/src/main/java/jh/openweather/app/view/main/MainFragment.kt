package jh.openweather.app.view.main

import androidx.navigation.fragment.findNavController
import jh.openweather.app.R
import jh.openweather.app.databinding.FragmentMainBinding
import jh.openweather.app.view.BaseFragment
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel : MainViewModel by inject()

    override fun initView() {
        viewModel.getWeather()
    }

    override fun isNetworkConnected(isConnected: Boolean) {
        Timber.d("%s%s","isNetworkConnected ", isConnected)
    }

    override fun onPause() {
        super.onPause()

    }

}