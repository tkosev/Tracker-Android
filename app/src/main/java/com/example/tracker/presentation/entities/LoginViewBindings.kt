package com.example.tracker.presentation.entities

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import com.example.tracker.presentation.ui.login.LoginErrors

class LoginViewBindings : BaseObservable() {

    /** Error user login indicator*/
    var loginErrorMessage: MutableLiveData<LoginErrors> = MutableLiveData()

    /** Success user login indicator*/
    val loginSuccessLiveData: MutableLiveData<Boolean> = MutableLiveData()

    var userEmail: String? = null
        @Bindable get() = field
        set(userName) {
            field = userName
            notifyPropertyChanged(BR.userEmail)
        }

    var userPassWord: String? = null
        @Bindable get() = field
        set(userPassWord) {
            field = userPassWord
            notifyPropertyChanged(BR.userPassWord)
        }

    var errorMessage: String? = null
        @Bindable get() = field
        set(userPassWord) {
            field = userPassWord
            notifyPropertyChanged(BR.errorMessage)
        }

    /**Function to check if the email and password are valid*/
    fun isValid(): Boolean =
        android.util.Patterns.EMAIL_ADDRESS.matcher(userEmail!!).matches() && userPassWord!!.length > 6
}