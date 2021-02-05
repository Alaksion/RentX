package com.example.rentx.authentication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.rentx.R
import kotlinx.android.synthetic.main.fragment_register_email.*


class RegisterFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            bt_register_mail_next.id ->
                Navigation.findNavController(v)
                    .navigate(R.id.action_registerFragment_to_registerPasswordFragment)

            register_mail_go_back.id ->
                Navigation.findNavController(v)
                    .navigate(R.id.action_registerFragment_to_authMenuFragment)

        }
    }

    private fun setupListeners() {
        bt_register_mail_next.setOnClickListener(this)
        register_mail_go_back.setOnClickListener(this)
    }


}