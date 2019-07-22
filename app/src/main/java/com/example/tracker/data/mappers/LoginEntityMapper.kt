package com.example.tracker.data.mappers

import com.example.tracker.domain.Mapper
import com.example.tracker.domain.entities.LoginEntity
import com.example.tracker.presentation.entities.Login
import com.example.tracker.presentation.ui.login.FireBaseLoginErrors
import javax.inject.Inject

class LoginEntityMapper  @Inject constructor()  : Mapper<String, FireBaseLoginErrors>() {
    override fun mapFrom(from: String): FireBaseLoginErrors {
        return when (from) {
            "login_error_email_invalid" -> FireBaseLoginErrors.INVALID_EMAIL
            "The password is invalid or the user does not have a password." -> FireBaseLoginErrors.INVALID_PASSWORD
            "Given String is empty or null" ->   FireBaseLoginErrors.INVALID_CREDENTIALS
            else -> {
                FireBaseLoginErrors.INVALID_CREDENTIALS
            }
        }
    }
}