package com.example.tracker.presentation.ui.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.tracker.base.BaseViewModel
import com.example.tracker.domain.Mapper
import com.example.tracker.domain.usecases.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase, private val mapper: Mapper<String,LoginErrors>) : BaseViewModel() {

    /** User Email*/
    var emailAddress = MutableLiveData<String>()

    /** User Password*/
    var password = MutableLiveData<String>()

    var errorMessage = MutableLiveData<String>()
    var loginErrorMessage = MutableLiveData<LoginErrors>()

    /** Success user login indicator*/
    val loginSuccessLiveData: MutableLiveData<Boolean> = MutableLiveData()

    /** Method called when user clicks on login button */
    fun onLoginButtonClick(view: View) {
        addDisposable(loginUseCase.login(emailAddress.value!!, password.value!!)
            .doOnError {
                loginErrorMessage.value = mapper.mapFrom(it.localizedMessage!!)
            }.subscribe({
                loginSuccessLiveData.value = true
            }, { error ->
                errorMessage.value = error.localizedMessage
            })
        )
    }
}
