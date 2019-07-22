package com.example.tracker.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tracker.databinding.FragmentLoginBinding
import com.example.tracker.presentation.ui.App
import com.example.tracker.presentation.ui.base.BaseFragment
import com.example.tracker.presentation.ui.home.HomeActivity
import javax.inject.Inject



@Suppress("JAVA_CLASS_ON_COMPANION")
class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
        var TAG: String = LoginFragment.javaClass.name
    }

    @Inject
    lateinit var factory: LoginVMFactory

    private lateinit var viewModel: LoginViewModel

    private var binding: FragmentLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as App).createLoginComponent().inject(this)

        initViewModel()

        observeViewModelState()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate(inflater, com.example.tracker.R.layout.fragment_login,container,false)
        this.binding?.lifecycleOwner = this
        this.binding?.loginViewModel = viewModel
        return binding?.root
    }

    private fun initViewModel() {
        this.viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
    }

    private fun observeViewModelState(){
        this.viewModel.loginSuccessLiveData.observe(this, Observer {
            if (it != null) handleLoginSuccess()
        })

        this.viewModel.errorMessage.observe(this, Observer {
            if (it != null) handleLoginSuccess()
        })
    }

    private fun handleLoginSuccess() = this.startActivity(Intent(activity, HomeActivity::class.java))

}
