package com.example.tracker.presentation.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.tracker.injection.ViewModelFactory
import com.example.tracker.presentation.ui.login.LoginVMFactory
import com.example.tracker.presentation.ui.login.LoginViewModel
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}