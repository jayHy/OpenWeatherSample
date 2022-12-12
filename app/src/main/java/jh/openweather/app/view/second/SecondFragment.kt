package jh.openweather.app.view.second

import jh.openweather.app.R
import jh.openweather.app.databinding.FragmentSecondBinding
import jh.openweather.app.view.BaseFragment
import timber.log.Timber

class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {

    override fun initView() {

    }

    override fun isNetworkConnected(isConnected: Boolean) {
        Timber.d("%s%s","isNetworkConnected ", isConnected)
    }


}