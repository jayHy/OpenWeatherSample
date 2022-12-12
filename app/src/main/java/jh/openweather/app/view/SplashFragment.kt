package jh.openweather.app.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import jh.openweather.app.R
import jh.openweather.app.databinding.FragmentSplashBinding
import jh.openweather.app.utils.navigateSafe
import timber.log.Timber

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    // View 초기화 완료
    override fun initView() {
        Timber.d("initView")
        binding.apply {

        }

        findNavController().navigateSafe(
            SplashFragmentDirections.actionSplashToMain()
        )
    }

    // Network 변경 체크
    override fun isNetworkConnected(isConnected: Boolean) {
        Timber.d("%s%s","isNetworkConnected ", isConnected)
    }

}