package com.example.tracker.injection.welcome

import com.example.tracker.presentation.ui.welcome.WelcomeVMFactory
import dagger.Module
import dagger.Provides


@Module
class WelcomeModule {


    @WelcomeScope
    @Provides
    fun provideWelcomeVMFactory() : WelcomeVMFactory {
        return WelcomeVMFactory()
    }
}