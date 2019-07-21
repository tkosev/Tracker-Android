package com.example.tracker.injection.login

import com.example.tracker.presentation.ui.login.LoginFragment
import dagger.Subcomponent

@LoginScope
@Subcomponent(modules = [LoginModule::class])
interface LoginSubComponent {

    fun inject(loginFragment: LoginFragment)
}
