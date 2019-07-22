package com.example.tracker.domain.repository

import com.google.firebase.auth.AuthResult
import io.reactivex.Maybe
import io.reactivex.Observable

interface FireBaseAuthRepo {

    fun loginEmailPassword(email:String, password :String) : Maybe<AuthResult>

    fun signUp(email: String, password: String) : Maybe<AuthResult>
}