package com.example.tracker.presentation.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tracker.domain.usecases.RegisterUseCase

class RegisterVMFactory(private val registerUseCase: RegisterUseCase) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T = RegisterViewModel(registerUseCase) as T
}