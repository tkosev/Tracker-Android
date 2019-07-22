package com.example.tracker.presentation.ui.register

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.tracker.base.BaseViewModel
import com.example.tracker.domain.usecases.RegisterUseCase

class RegisterViewModel(private val registerUseCase: RegisterUseCase) : BaseViewModel() {

    /** User Email*/
    var emailAddress = MutableLiveData<String>()

    /** User Password*/
    var password = MutableLiveData<String>()

    /** Method called when user clicks on login button */
    fun onRegisterButtonClick(view: View) {
        addDisposable(
            registerUseCase.register(emailAddress.value!!, password.value!!)
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
