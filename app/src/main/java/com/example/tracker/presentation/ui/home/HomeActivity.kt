package com.example.tracker.presentation.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.tracker.R
import com.example.tracker.R.id
import com.example.tracker.R.layout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home)

        initNavGraph()
        setupNavDrawer()
        setupToolbar()

        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.isChecked = true
        drawer_layout.closeDrawers()
        when (menuItem.itemId) {
           id.home -> Navigation.findNavController(this, id.nav_host_fragment).navigate(id.homeFragment)
           id.camera -> Navigation.findNavController(this, id.nav_host_fragment).navigate(id.cameraFragment)
        }
        return true
    }

    private fun initNavGraph() {
        NavigationUI.setupActionBarWithNavController(this, Navigation.findNavController(this, id.nav_host_fragment))
    }

    private fun setupNavDrawer() {
        nav_view?.let {
            NavigationUI.setupWithNavController(it, Navigation.findNavController(this, id.nav_host_fragment))
        }
    }

    private fun setupToolbar() {
        NavigationUI.setupActionBarWithNavController(this, Navigation.findNavController(this, id.nav_host_fragment))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navigated = NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(this, id.nav_host_fragment))
        return navigated || super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean =
        NavigationUI.navigateUp(Navigation.findNavController(this, id.nav_host_fragment), drawer_layout)


}
