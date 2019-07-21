package com.example.tracker.injection.welcome

import com.example.tracker.presentation.ui.welcome.WelcomeFragment
import dagger.Subcomponent


@WelcomeScope
@Subcomponent(modules = [WelcomeModule::class])
interface WelcomeSubComponent {

    fun inject(welcomeFragment: WelcomeFragment)
}
