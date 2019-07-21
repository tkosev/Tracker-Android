package com.example.tracker.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tracker.databinding.ActivityLoginBinding
import com.example.tracker.presentation.ui.App
import com.example.tracker.presentation.ui.home.HomeActivity
import javax.inject.Inject


class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: LoginVMFactory

    private lateinit var viewModel: LoginViewModel

    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, com.example.tracker.R.layout.activity_login)

        (application as App).createLoginComponent().inject(this)

        initViewModel()

        initDataBinding()

        observeViewModelState()
    }

    private fun initViewModel() {
        this.viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
    }

    private fun initDataBinding(){
        this.binding?.lifecycleOwner = this
        this.binding?.loginViewModel = viewModel
    }

    private fun observeViewModelState(){
        this.viewModel.loginSuccessLiveData.observe(this, Observer {
            if (it != null) handleLoginSuccess()
        })
    }

    private fun handleLoginSuccess() = this.startActivity(Intent(this, HomeActivity::class.java))

}
