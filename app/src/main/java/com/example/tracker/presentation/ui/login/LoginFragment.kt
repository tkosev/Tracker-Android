package com.example.tracker.presentation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.tracker.App
import com.example.tracker.databinding.FragmentLoginBinding
import com.example.tracker.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
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
        this.binding = DataBindingUtil.inflate(inflater, com.example.tracker.R.layout.fragment_login, container, false)
        this.binding?.lifecycleOwner = this
        this.binding?.loginViewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        txtRegisterNow.setOnClickListener {
            val registerAction = LoginFragmentDirections.actionRegister()
            Navigation.findNavController(it).navigate(registerAction)
        }
        txtForgotPassword.setOnClickListener {
            val forgotPasswordAction = LoginFragmentDirections.actionForgotPassword()
            Navigation.findNavController(it).navigate(forgotPasswordAction)
        }
    }

    private fun initViewModel() {
        this.viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
    }

    private fun observeViewModelState() {
        this.viewModel.loginBindings.loginSuccessLiveData.observe(this, Observer {
            if (it != null) handleLoginSuccess()
        })
        this.viewModel.loginBindings.loginErrorMessage.observe(this, Observer {
            if (it != null) handleLoginError(it)
        })
    }

    private fun handleLoginSuccess() {
        val actionHome = LoginFragmentDirections.actionHome()
        Navigation.findNavController(this.view!!).navigate(actionHome)
        activity?.finish()
    }

    private fun handleLoginError(fireBaseError: LoginErrors) {
        when (fireBaseError) {
            LoginErrors.INVALID_CREDENTIALS -> {
                YoYo.with(Techniques.Shake).playOn(emailInputView)
                YoYo.with(Techniques.Shake).playOn(passwordInputView)
            }
            LoginErrors.INVALID_PASSWORD -> YoYo.with(Techniques.Shake).playOn(passwordInputView)
            LoginErrors.INVALID_EMAIL -> YoYo.with(Techniques.Shake).playOn(emailInputView)
            LoginErrors.OTHER -> {
            }
        }
    }
}
