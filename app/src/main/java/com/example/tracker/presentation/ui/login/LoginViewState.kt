package com.example.tracker.presentation.ui.login

import android.util.Patterns
import androidx.databinding.BaseObservable

data class LoginViewState(
    var isLoginSuccess :Boolean,
    var errorMessage : String) : BaseObservable() {


}