package com.example.tracker.injection.component

import com.example.tracker.injection.network.NetworkModule
import com.example.tracker.presentation.ui.login.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param loginViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(loginViewModel: LoginViewModel)

    // fun inject(postViewModel: LoginViewModel)

    @Component.Builder
    interface Builder {

        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}