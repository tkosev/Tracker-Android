package com.example.tracker.presentation.ui

import android.app.Application
import com.example.tracker.injection.application.AppModule
import com.example.tracker.injection.application.DaggerMainComponent
import com.example.tracker.injection.application.MainComponent
import com.example.tracker.injection.login.LoginModule
import com.example.tracker.injection.login.LoginSubComponent
import com.example.tracker.injection.welcome.WelcomeModule
import com.example.tracker.injection.welcome.WelcomeSubComponent

class App : Application() {

    lateinit var mainComponent: MainComponent

    private var loginComponent: LoginSubComponent? = null
    private var welcomeComponent: WelcomeSubComponent? = null

    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    private fun initDependencies() {
        mainComponent = DaggerMainComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    fun createLoginComponent(): LoginSubComponent {
        loginComponent = mainComponent.plus(LoginModule())
        return loginComponent!!
    }

    fun createWelcomeComponent(): WelcomeSubComponent {
        welcomeComponent = mainComponent.plus(WelcomeModule())
        return welcomeComponent!!
    }

    //override fun activityInjector(): AndroidInjector<Activity>? {
    //    return activityDispatchingAndroidInjector
    //}
}
