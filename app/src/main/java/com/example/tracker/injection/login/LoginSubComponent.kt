package com.example.tracker.injection.login

import com.example.tracker.presentation.ui.login.LoginActivity
import dagger.Subcomponent

@LoginScope
@Subcomponent(modules = [LoginModule::class])
interface LoginSubComponent {

    fun inject(loginActivity: LoginActivity)
}
