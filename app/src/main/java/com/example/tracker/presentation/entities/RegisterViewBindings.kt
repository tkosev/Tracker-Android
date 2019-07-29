package com.example.tracker.presentation.entities

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class RegisterViewBindings : BaseObservable() {

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
}