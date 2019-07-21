package com.example.tracker.injection.data

import com.example.tracker.data.repository.FireBaseAuthRepoImpl
import com.example.tracker.domain.repository.FireBaseAuthRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository(): FireBaseAuthRepo {
        return FireBaseAuthRepoImpl()
    }

}