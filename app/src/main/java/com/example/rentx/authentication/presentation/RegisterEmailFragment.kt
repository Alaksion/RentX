package com.example.rentx.authentication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.rentx.R
import com.example.rentx.databinding.FragmentRegisterEmailBinding
import kotlinx.android.synthetic.main.fragment_register_email.*


class RegisterFragment : Fragment(), View.OnClickListener {

    private lateinit var viewBinding: FragmentRegisterEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register_email, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            bt_register_mail_next.id -> handleNavigateToPasswordScreen(v)

            register_mail_go_back.id ->
                Navigation.findNavController(v)
                    .navigate(R.id.action_registerFragment_to_authMenuFragment)

        }
    }

    private fun setupListeners() {
        bt_register_mail_next.setOnClickListener(this)
        register_mail_go_back.setOnClickListener(this)
    }

    private fun handleNavigateToPasswordScreen(v: View) {
        val email = viewBinding.etRegisterEmail.text.toString()
        val name = viewBinding.etRegisterName.text.toString()

        val destination =
            RegisterFragmentDirections.actionRegisterFragmentToRegisterPasswordFragment(email, name)

        v.findNavController().navigate(destination)
    }


}