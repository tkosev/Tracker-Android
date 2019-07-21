package com.example.tracker.presentation.ui.login

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.tracker.base.BaseViewModel
import com.example.tracker.domain.Mapper
import com.example.tracker.domain.entities.LoginEntity
import com.example.tracker.domain.usecases.LoginUseCase
import com.example.tracker.presentation.entities.Login

class LoginViewModel(private val loginUseCase: LoginUseCase, private val mapper: Mapper<LoginEntity, Login>) : BaseViewModel() {

    /** User Email*/
    var emailAddress = MutableLiveData<String>()

    /** User Password*/
    var password = MutableLiveData<String>()

    /** User Password*/
    var isError = MutableLiveData<Boolean>()

    /** User Password*/
    var errorMessage = MutableLiveData<String>()

    /** Success user login indicator*/
    val loginSuccessLiveData: MutableLiveData<Boolean> = MutableLiveData()

    init {
        emailAddress.value = ""
        password.value = ""
    }

    /** Method called when user clicks on login button */
    fun onLoginButtonClick(view: View) {
        addDisposable(
            loginUseCase.login(emailAddress.value!!, password.value!!)
                .subscribe({ success ->
                    isError.value = false
                    loginSuccessLiveData.value = success

                }, { error ->
                    Log.e("Login", "onError: " + error.localizedMessage)
                    isError.value = true
                    errorMessage.value = error.localizedMessage
                }, {
                    Log.e("Login", "onComplete")
                })
        )
    }
}