package com.example.tracker.presentation.ui.login

import android.text.TextUtils
import android.widget.EditText
import androidx.databinding.BindingAdapter


class LoginBindingAdapter {
    @BindingAdapter("passwordValidator")
    fun passwordValidator(editText: EditText, password: String) {
        // ignore infinite loops
        val minimumLength = 5
        if (TextUtils.isEmpty(password)) {
            editText.error = null
            return
        }
        if (editText.text.toString().length < minimumLength) {
            editText.error = "Password must be minimum $minimumLength length"
        } else
            editText.error = null
    }
}