package com.example.rentx.authentication.presentation.registerforms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rentx.R
import kotlinx.android.synthetic.main.fragment_register_password.*


class RegisterPasswordFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            register_password_go_back.id ->
                Navigation.findNavController(v)
                    .navigate(R.id.action_registerPasswordFragment_to_registerFragment)

            bt_submit_register.id ->
                Navigation.findNavController(v)
                    .navigate(R.id.action_registerPasswordFragment_to_registerSuccessFragment)
        }
    }

    private fun setupListeners() {
        register_password_go_back.setOnClickListener(this)
        bt_submit_register.setOnClickListener(this)
    }
}