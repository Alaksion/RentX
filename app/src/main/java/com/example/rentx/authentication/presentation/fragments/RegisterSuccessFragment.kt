package com.example.rentx.authentication.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.rentx.R
import com.example.rentx.databinding.FragmentRegisterSuccessBinding

class RegisterSuccessFragment : Fragment() {

    private lateinit var viewBinding: FragmentRegisterSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register_success, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        viewBinding.btOk.setOnClickListener {
            val destination =
                RegisterSuccessFragmentDirections.actionRegisterSuccessFragmentToLoginFragment()

            Navigation.findNavController(viewBinding.root).navigate(destination)
        }
    }
}