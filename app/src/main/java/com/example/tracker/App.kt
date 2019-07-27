package com.example.tracker

import android.app.Application
import android.content.Context
import com.example.tracker.injection.application.AppModule
import com.example.tracker.injection.application.DaggerMainComponent
import com.example.tracker.injection.application.MainComponent
import com.example.tracker.injection.login.LoginModule
import com.example.tracker.injection.login.LoginSubComponent
import com.example.tracker.injection.register.RegisterModule
import com.example.tracker.injection.register.RegisterSubComponent
import com.example.tracker.injection.welcome.WelcomeModule
import com.example.tracker.injection.welcome.WelcomeSubComponent
import androidx.multidex.MultiDex



class App : Application() {

    private lateinit var mainComponent: MainComponent

    private var loginComponent: LoginSubComponent? = null
    private var welcomeComponent: WelcomeSubComponent? = null
    private var registerSubComponent: RegisterSubComponent? = null

    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
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

    fun createRegisterComponent(): RegisterSubComponent {
        registerSubComponent = mainComponent.plus(RegisterModule())
        return registerSubComponent!!
    }

    fun createWelcomeComponent(): WelcomeSubComponent {
        welcomeComponent = mainComponent.plus(WelcomeModule())
        return welcomeComponent!!
    }

    //override fun activityInjector(): AndroidInjector<Activity>? {
    //    return activityDispatchingAndroidInjector
    //}
}
