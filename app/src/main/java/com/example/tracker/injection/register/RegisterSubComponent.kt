package com.example.tracker.injection.register
import com.example.tracker.presentation.ui.register.RegisterFragment
import dagger.Subcomponent

@RegisterScope
@Subcomponent(modules = [RegisterModule::class])
interface RegisterSubComponent {

    fun inject(registerFragment: RegisterFragment)
}


