package com.example.rentx.authentication.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import com.example.rentx.R
import kotlinx.android.synthetic.main.fragment_auth_menu.*


class AuthMenuFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            bt_menu_login.id -> Navigation.findNavController(v)
                .navigate(R.id.action_authMenuFragment_to_loginFragment)

            bt_menu_register.id -> Navigation.findNavController(v)
                .navigate(R.id.action_authMenuFragment_to_registerFragment)
        }
    }

    private fun setListeners() {
        bt_menu_login.setOnClickListener(this)
        bt_menu_register.setOnClickListener(this)
    }

}