package com.example.tracker.data.mappers

import com.example.tracker.domain.Mapper
import com.example.tracker.domain.entities.LoginEntity
import com.example.tracker.presentation.entities.Login
import javax.inject.Inject

class LoginEntityMapper  @Inject constructor()  : Mapper<LoginEntity, Login>() {

    override fun mapFrom(from: LoginEntity): Login {
        return Login(from.isLoginSuccess,from.errorMessage)
    }
}