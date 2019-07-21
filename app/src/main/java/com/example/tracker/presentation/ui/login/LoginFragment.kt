package com.example.tracker.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tracker.databinding.ActivityLoginBinding
import com.example.tracker.presentation.ui.App
import com.example.tracker.presentation.ui.base.BaseFragment
import com.example.tracker.presentation.ui.home.HomeActivity
import com.example.tracker.presentation.ui.register.RegisterFragment
import com.example.tracker.presentation.ui.welcome.WelcomeFragment
import javax.inject.Inject


class LoginFragment : BaseFragment() {


    companion object {
        fun newInstance() = LoginFragment()
        var TAG: String = LoginFragment.javaClass.name
    }

    @Inject
    lateinit var factory: LoginVMFactory

    private lateinit var viewModel: LoginViewModel

    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as App).createLoginComponent().inject(this)

        initViewModel()

        observeViewModelState()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate(inflater, com.example.tracker.R.layout.activity_login,container,false)
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
    }

    private fun handleLoginSuccess() {
        this.startActivity(Intent(activity, HomeActivity::class.java))
    }

}
