package com.example.tracker.presentation.ui.login

import android.view.View
import com.example.tracker.base.BaseViewModel
import com.example.tracker.domain.Mapper
import com.example.tracker.domain.usecases.LoginUseCase
import com.example.tracker.presentation.entities.LoginParams

class LoginViewModel(private val loginUseCase: LoginUseCase, private val mapper: Mapper<String,LoginErrors>) : BaseViewModel() {

    var login : LoginParams = LoginParams()

    /** Method called when user clicks on login button */
    fun onLoginButtonClick(view: View) {
       if(login.isValid()) {
            addDisposable(loginUseCase.login(login.userEmail!!, login.userPassWord!!)
                .doOnError {
                    login.loginErrorMessage.value = mapper.mapFrom(it.localizedMessage!!)
                }.subscribe({
                    login.loginSuccessLiveData.value = true
                }, { error ->
                    login.errorMessage=error.localizedMessage
                })
            )
        }
    }
}
