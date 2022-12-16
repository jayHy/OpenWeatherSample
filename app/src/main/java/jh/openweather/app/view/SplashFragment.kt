package jh.openweather.app.view

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
        checkPermission()
        binding.apply {}
    }

    // Network 변경 체크
    override fun isNetworkConnected(isConnected: Boolean) {
        Timber.d("%s%s","isNetworkConnected ", isConnected)
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // 권한 있음
            Timber.d("checkPermission success")
        } else {
            var isPermission = true
            val requestMultiplePermissions = registerForActivityResult(
                ActivityResultContracts.RequestMultiplePermissions()
            ) { permissions ->
                permissions.entries.forEach { permission ->
                    isPermission = permission.value
                }

                if(isPermission) {
                    // 권한 수락함.
                    Timber.d("checkPermission accept")
                } else {
                    val alertDialog = AlertDialog.Builder(requireContext()).apply {
                        setCancelable(false)
                        setTitle("앱 권한 설정")
                        setMessage("권한 부족으로 앱 설정이 필요합니다.")
                        setPositiveButton("확인"
                        ) { dialogInterface, _ ->
                            startActivity(
                                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                data = Uri.fromParts("package", requireContext().packageName, null)
                                }
                            )
                            dialogInterface.cancel()
                        }
                        setNegativeButton("종료"
                        ) { dialogInterface, _ ->
                            dialogInterface.cancel()
                            requireActivity().finish()
                        }
                    }
                    alertDialog.show()
                }

            }

            requestMultiplePermissions.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )

        }
    }

    private fun actionToMain() {
        findNavController().navigateSafe(
            SplashFragmentDirections.actionSplashToMain()
        )
    }

}