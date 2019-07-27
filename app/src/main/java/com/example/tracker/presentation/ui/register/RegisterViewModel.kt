package com.example.tracker.presentation.ui.register

import android.util.Log
import android.view.View
import com.example.tracker.base.BaseViewModel
import com.example.tracker.domain.usecases.RegisterUseCase
import com.example.tracker.presentation.entities.RegisterViewBindings

class RegisterViewModel(private val registerUseCase: RegisterUseCase) : BaseViewModel() {

    var registerViewBindings :RegisterViewBindings = RegisterViewBindings()

    /** Method called when user clicks on login button */
    fun onRegisterButtonClick(view: View) {
        addDisposable(
            registerUseCase.register(registerViewBindings.userEmail!!, registerViewBindings.userPassWord!!)
                .subscribe({ success ->
                    Log.e("Register", success.toString())
                }, { error ->
                    Log.e("Register", "onError: " + error.localizedMessage)
                }, {
                    Log.e("Register", "onComplete")
                })
        )
    }
}
