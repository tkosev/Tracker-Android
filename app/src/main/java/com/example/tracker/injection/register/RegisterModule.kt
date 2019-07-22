package com.example.tracker.injection.register

import com.example.tracker.domain.usecases.RegisterUseCase
import com.example.tracker.presentation.transformer.AsyncTransformer
import com.example.tracker.presentation.ui.register.RegisterVMFactory
import dagger.Module
import dagger.Provides

@Module
class RegisterModule {

    @RegisterScope
    @Provides
    fun provideRegisterUseCase(): RegisterUseCase {
        return RegisterUseCase(AsyncTransformer())
    }
    @RegisterScope
    @Provides
    fun provideRegisterVMFactory(registerUseCase: RegisterUseCase) : RegisterVMFactory {
        return RegisterVMFactory(registerUseCase)
    }


}