package com.example.rentx.authentication.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rentx.R
import com.example.rentx.home.presentation.HomeActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            login_back_button.id -> Navigation.findNavController(v)
                .navigate(R.id.action_loginFragment_to_authMenuFragment)

            bt_login.id -> {
                handleNavigateToHomePage()
            }
        }
    }

    private fun setListeners() {
        login_back_button.setOnClickListener(this)
        bt_login.setOnClickListener(this)
    }

    private fun handleNavigateToHomePage(){
        HomeActivity.start(requireActivity())
        requireActivity().finish()
    }

}