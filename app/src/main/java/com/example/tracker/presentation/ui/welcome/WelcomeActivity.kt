package com.example.tracker.presentation.ui.welcome
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.tracker.R
import com.example.tracker.presentation.ui.base.BaseActivity

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initNavGraph()
    }

    private fun initNavGraph() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()
}
