package com.example.tracker.presentation.ui.login

import android.view.View
import com.example.tracker.base.BaseViewModel
import com.example.tracker.domain.Mapper
import com.example.tracker.domain.usecases.LoginUseCase
import com.example.tracker.presentation.entities.LoginViewBindings

class LoginViewModel(private val loginUseCase: LoginUseCase, private val mapper: Mapper<String,LoginErrors>) : BaseViewModel() {

    var loginBindings : LoginViewBindings = LoginViewBindings()


    /** Method called when user clicks on login button */
    fun onLoginButtonClick(view: View) {
       if(loginBindings.isValid()) {
            addDisposable(loginUseCase.login(loginBindings.userEmail!!, loginBindings.userPassWord!!)
                .doOnError {
                    loginBindings.loginErrorMessage.value = mapper.mapFrom(it.localizedMessage!!)
                }.subscribe({
                    loginBindings.loginSuccessLiveData.value = true
                }, { error ->
                    loginBindings.errorMessage = error.localizedMessage
                })
            )
        }
        else{
            //TODO:
       }
    }
}
