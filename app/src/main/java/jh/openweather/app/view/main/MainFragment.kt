package jh.openweather.app.view.main

import android.Manifest
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import jh.openweather.app.R
import jh.openweather.app.databinding.FragmentMainBinding
import jh.openweather.app.view.BaseFragment
import org.koin.android.ext.android.inject
import timber.log.Timber
import java.util.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel : MainViewModel by inject()

    override fun initView() {
        getLocation()
        viewModel.weatherLiveData.observe(viewLifecycleOwner) { weather ->
            Timber.d("%s", weather)
        }
    }

    private fun getLocation() {
        val locationManager = requireContext().getSystemService(LOCATION_SERVICE) as LocationManager
        val isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if(!isGPSEnabled && !isNetworkEnabled) {
            // 네트워크랑 GPS 둘 다 off.
        } else {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {

                val location = if(isNetworkEnabled)  {
                    locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                } else { // Network Enabled
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                }

                location?.let {
                    val geocoder = Geocoder(requireContext(), Locale.getDefault())
                    geocoder.getFromLocation(it.latitude, it.longitude, 5)
                    viewModel.getWeather(lat = it.latitude, lon = it.longitude)
                }
            } else {
                Timber.d("")
            }
        }

    }

    override fun isNetworkConnected(isConnected: Boolean) {
        Timber.d("%s%s","isNetworkConnected ", isConnected)
    }

}