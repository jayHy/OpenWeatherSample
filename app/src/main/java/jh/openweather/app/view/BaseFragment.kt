package jh.openweather.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import jh.openweather.app.utils.NetworkConnection

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes val layoutRes: Int) : Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!

    lateinit var networkCheckLiveData : LiveData<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        NetworkConnection(requireContext()).observe(viewLifecycleOwner) { isConnected ->
            isNetworkConnected(isConnected)
        }
        initView()
    }

    protected abstract fun initView()

    protected abstract fun isNetworkConnected(isConnected : Boolean)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}