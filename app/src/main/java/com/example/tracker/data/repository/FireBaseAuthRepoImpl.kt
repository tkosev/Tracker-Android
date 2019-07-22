package com.example.tracker.data.repository

import com.example.tracker.domain.repository.FireBaseAuthRepo
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import durdinapps.rxfirebase2.RxFirebaseAuth
import io.reactivex.Maybe
import io.reactivex.Observable

class FireBaseAuthRepoImpl : FireBaseAuthRepo {

    /*** Method to sign-up with FireBase SDK */
    override fun signUp(email: String, password: String): Maybe<AuthResult>{
        return RxFirebaseAuth.createUserWithEmailAndPassword(FirebaseAuth.getInstance(),email,password)
    }

    /*** Method to sign-in with FireBase SDK */
    override fun loginEmailPassword(email: String, password: String): Maybe<AuthResult> {
        return RxFirebaseAuth.signInWithEmailAndPassword(FirebaseAuth.getInstance(), email,password)
    }


}