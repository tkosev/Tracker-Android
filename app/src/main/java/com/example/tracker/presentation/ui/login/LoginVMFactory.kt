package com.example.tracker.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tracker.data.mappers.LoginEntityMapper
import com.example.tracker.domain.Mapper
import com.example.tracker.domain.entities.LoginEntity
import com.example.tracker.domain.usecases.LoginUseCase
import com.example.tracker.presentation.entities.Login


class LoginVMFactory(private val useCase: LoginUseCase, private val mapper:LoginEntityMapper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(useCase,mapper) as T
    }

}