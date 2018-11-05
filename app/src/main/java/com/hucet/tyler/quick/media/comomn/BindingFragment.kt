package kr.co.irobo.advice.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hucet.tyler.quick.media.utils.autoCleared
import javax.inject.Inject

abstract class BindingFragment<T : ViewDataBinding> : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    var binding by autoCleared<T>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val dataBinding = DataBindingUtil.inflate<T>(inflater, bindResId, container, false)
        binding = dataBinding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    abstract val bindResId: Int
}