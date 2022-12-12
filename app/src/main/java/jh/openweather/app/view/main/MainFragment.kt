package jh.openweather.app.view.main

import androidx.navigation.fragment.findNavController
import jh.openweather.app.R
import jh.openweather.app.databinding.FragmentMainBinding
import jh.openweather.app.utils.navigateSafe
import jh.openweather.app.view.BaseFragment
import timber.log.Timber

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun initView() {
        findNavController().navigateSafe(
            MainFragmentDirections.actionMainToSecond()
        )
    }

    override fun isNetworkConnected(isConnected: Boolean) {
        Timber.d("%s%s","isNetworkConnected ", isConnected)
    }

    override fun onPause() {
        super.onPause()

    }

}