package com.example.tracker.data.mappers

import com.example.tracker.domain.Mapper
import com.example.tracker.presentation.ui.login.LoginErrors
import javax.inject.Inject

class LoginEntityMapper  @Inject constructor()  : Mapper<String, LoginErrors>() {
    override fun mapFrom(from: String): LoginErrors {
        return when (from) {
            "login_error_email_invalid" -> LoginErrors.INVALID_EMAIL
            "The password is invalid or the user does not have a password." -> LoginErrors.INVALID_PASSWORD
            "Given String is empty or null" ->   LoginErrors.INVALID_CREDENTIALS
            else -> {
                LoginErrors.INVALID_CREDENTIALS
            }
        }
    }
}