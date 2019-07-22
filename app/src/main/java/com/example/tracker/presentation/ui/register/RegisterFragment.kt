package com.example.tracker.presentation.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.tracker.R
import com.example.tracker.presentation.ui.App
import com.example.tracker.presentation.ui.login.LoginViewModel
import javax.inject.Inject

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
        var TAG: String = RegisterFragment.javaClass.name
    }

    private lateinit var viewModel: RegisterViewModel

    @Inject
    lateinit var factory : RegisterVMFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).createRegisterComponent().inject(this)
        initViewModel()
    }

    private fun initViewModel() {
        this.viewModel = ViewModelProviders.of(this, factory).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }



}
