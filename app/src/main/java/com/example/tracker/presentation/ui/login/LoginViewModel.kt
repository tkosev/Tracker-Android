package com.example.tracker.presentation.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.tracker.base.BaseViewModel
import com.example.tracker.domain.Mapper
import com.example.tracker.domain.usecases.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase, private val mapper: Mapper<String,LoginErrors>) : BaseViewModel() {

    var login : LoginParams = LoginParams()

    var loginErrorMessage :MutableLiveData<LoginErrors> = MutableLiveData()

    /** Success user login indicator*/
    val loginSuccessLiveData: MutableLiveData<Boolean> = MutableLiveData()

    /** Method called when user clicks on login button */
    fun onLoginButtonClick(view: View) {
       if(login.isValid()) {
            addDisposable(loginUseCase.login(login.userEmail!!, login.userPassWord!!)
                .doOnError {
                    loginErrorMessage.value = mapper.mapFrom(it.localizedMessage!!)
                }.subscribe({
                    loginSuccessLiveData.value = true
                }, { error ->
                    login.errorMessage=error.localizedMessage
                })
            )
        }

    }
}
