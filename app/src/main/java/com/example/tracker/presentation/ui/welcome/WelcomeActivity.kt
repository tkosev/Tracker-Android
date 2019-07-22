package com.example.tracker.presentation.ui.welcome

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.tracker.R
import com.example.tracker.common.replaceFragment
import kotlinx.android.synthetic.main.toolbar.*

class WelcomeActivity : AppCompatActivity() {

    lateinit var backStackListener: FragmentManager.OnBackStackChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initToolbar()
        loadWelcomeFragment()
    }

    private fun initToolbar(){
        if (!::backStackListener.isInitialized) {
            backStackListener = FragmentManager.OnBackStackChangedListener {
                updateToolbarViews()
            }
        }
        supportFragmentManager.addOnBackStackChangedListener(backStackListener)
    }

    private fun updateToolbarViews() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            toolbar.findViewById<ImageView>(R.id.toolbar_back_button).visibility = View.VISIBLE
            toolbar.findViewById<ImageView>(R.id.toolbar_back_button)
                .setOnClickListener { supportFragmentManager.popBackStack() }
        } else {
            toolbar.findViewById<ImageView>(R.id.toolbar_back_button).visibility = View.GONE
        }
    }

    private fun loadWelcomeFragment() = this.replaceFragment(R.id.container, WelcomeFragment.newInstance(), WelcomeFragment.TAG)


}
