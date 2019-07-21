package com.example.tracker.presentation.ui.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tracker.R
import com.example.tracker.common.replaceFragment
import com.example.tracker.presentation.ui.login.LoginFragment

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        loadWelcomeFragment()
    }


    private fun loadWelcomeFragment(){
        Log.e("App:" , "Welcome activity: loadWelcomeFragment()")
        replaceFragment(R.id.container, WelcomeFragment.newInstance(),"")
    }



}
