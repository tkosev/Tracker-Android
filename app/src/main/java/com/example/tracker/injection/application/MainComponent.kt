package com.example.tracker.injection.application

import com.example.tracker.injection.data.DataModule
import com.example.tracker.injection.login.LoginModule
import com.example.tracker.injection.login.LoginSubComponent
import com.example.tracker.injection.network.NetworkModule
import com.example.tracker.injection.welcome.WelcomeModule
import com.example.tracker.injection.welcome.WelcomeSubComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

const val SCHEDULER_MAIN_THREAD = "mainThread"
const val SCHEDULER_IO = "io"

@Singleton
@Component(modules = [
    (AppModule::class),
    (DataModule::class),
    (NetworkModule::class),
    (AndroidSupportInjectionModule::class)

    /*
    ,(MovieListFragmentModule::class)
,(ViewModelModule::class::class)
*/

])


interface MainComponent {
    fun plus(loginModule: LoginModule): LoginSubComponent
    fun plus(loginModule: WelcomeModule): WelcomeSubComponent


}