package com.example.tracker.injection.register

import com.example.tracker.domain.repository.FireBaseAuthRepo
import com.example.tracker.domain.usecases.RegisterUseCase
import com.example.tracker.presentation.transformer.AsyncTransformer
import com.example.tracker.presentation.ui.register.RegisterVMFactory
import dagger.Module
import dagger.Provides

@Module
class RegisterModule {

    @RegisterScope
    @Provides
    fun provideRegisterUseCase(authenticationRepository: FireBaseAuthRepo): RegisterUseCase {
        return RegisterUseCase(AsyncTransformer(),authenticationRepository)
    }
    @RegisterScope
    @Provides
    fun provideRegisterVMFactory(registerUseCase: RegisterUseCase) : RegisterVMFactory {
        return RegisterVMFactory(registerUseCase)
    }
}