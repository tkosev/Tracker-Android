package com.example.tracker.presentation.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.tracker.R
import com.example.tracker.databinding.WelcomeFragmentBinding
import com.example.tracker.presentation.ui.App
import com.example.tracker.presentation.ui.login.LoginFragment
import com.example.tracker.presentation.ui.register.RegisterFragment
import kotlinx.android.synthetic.main.welcome_fragment.*
import javax.inject.Inject

class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() = WelcomeFragment()
        var TAG: String = WelcomeFragment.javaClass.name
    }

    @Inject
    lateinit var factory: WelcomeVMFactory

    private var binding: WelcomeFragmentBinding? = null


    private lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.application as App).createWelcomeComponent().inject(this)

        initViewModel()
    }

    private fun initViewModel() {
        this.viewModel = ViewModelProviders.of(this, factory).get(WelcomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment,container,false)
        this.binding?.lifecycleOwner = this
        this.binding?.welcomeViewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtonListeners()
    }

    private fun initButtonListeners(){
        btnLoginNow.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.add(R.id.container,LoginFragment.newInstance(),LoginFragment.TAG)
                ?.addToBackStack(null)
                ?.commit()
        }

        btnRegisterEmail.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.add(R.id.container,RegisterFragment.newInstance(),RegisterFragment.TAG)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}
