package com.example.rentx.authentication.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.rentx.R
import com.example.rentx.authentication.presentation.AuthenticationViewModel
import com.example.rentx.databinding.FragmentRegisterPasswordBinding
import com.example.rentx.shared.providers.toasts.ToastProvider
import com.example.rentx.shared.providers.toasts.ToastType


class RegisterPasswordFragment : Fragment() {

    private lateinit var viewBinding: FragmentRegisterPasswordBinding
    private lateinit var mViewModel: AuthenticationViewModel
    private lateinit var toastProvider: ToastProvider

    private val args: RegisterPasswordFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_register_password,
                container,
                false
            )

        mViewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setUpObservers()
        toastProvider = ToastProvider(requireActivity())
    }


    private fun setupListeners() {
        viewBinding.registerPasswordGoBack.setOnClickListener() {
            val destination =
                RegisterPasswordFragmentDirections.actionRegisterPasswordFragmentToRegisterFragment()

            Navigation.findNavController(viewBinding.registerPasswordGoBack)
                .navigate(destination)

        }

        viewBinding.btSubmitRegister.setOnClickListener {
            handleRegisterClick()
        }

        viewBinding.etRegisterConfirmPassword.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.etRegisterPassword.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
    }

    private fun setUpObservers() {
        mViewModel.validationSuccess.observe(viewLifecycleOwner, Observer {
            if (!it.getResult()) {
                toastProvider.createToast(it.getMessage(), ToastType.ERROR)
            } else {
                handleNavigateToSuccessPage()
            }
        })
    }

    private fun handleRegisterClick() {
        val password = viewBinding.etRegisterPassword.text.toString()
        val confirmPassword = viewBinding.etRegisterConfirmPassword.text.toString()
        val email = args.email
        val name = args.name

        mViewModel.createAccount(name, email, password, confirmPassword)
    }

    private fun handleNavigateToSuccessPage() {
        val destination =
            RegisterPasswordFragmentDirections.actionRegisterPasswordFragmentToRegisterSuccessFragment()

        Navigation.findNavController(viewBinding.root)
            .navigate(destination)
    }

    private fun setButtonEnabledIfFieldsAreFilled() {
        val isPasswordFilled = viewBinding.etRegisterPassword.text.isNotEmpty()
        val isConfirmPasswordFilled = viewBinding.etRegisterConfirmPassword.text.isNotEmpty()

        viewBinding.btSubmitRegister.isEnabled = isPasswordFilled && isConfirmPasswordFilled
    }
}