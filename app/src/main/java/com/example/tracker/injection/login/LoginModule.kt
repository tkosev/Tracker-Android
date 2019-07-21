package com.example.tracker.injection.login

import com.example.tracker.data.mappers.LoginEntityMapper
import com.example.tracker.domain.repository.FireBaseAuthRepo
import com.example.tracker.domain.usecases.LoginUseCase
import com.example.tracker.presentation.transformer.AsyncTransformer
import com.example.tracker.presentation.ui.login.LoginVMFactory
import dagger.Module
import dagger.Provides


@Module
class LoginModule {



    @LoginScope
    @Provides
    fun provideLoginUseCase(authenticationRepository: FireBaseAuthRepo): LoginUseCase {
        return LoginUseCase(AsyncTransformer(), authenticationRepository)
    }
    @LoginScope
    @Provides
    fun provideLoginVMFactory(useCase: LoginUseCase, mapper: LoginEntityMapper)
            : LoginVMFactory {
        return LoginVMFactory(useCase, mapper)
    }


}