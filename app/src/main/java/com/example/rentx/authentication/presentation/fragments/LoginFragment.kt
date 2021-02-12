package com.example.rentx.authentication.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.rentx.R
import com.example.rentx.authentication.presentation.AuthenticationViewModel
import com.example.rentx.databinding.FragmentLoginBinding
import com.example.rentx.home.presentation.HomeActivity
import com.example.rentx.shared.providers.toasts.ToastProvider
import com.example.rentx.shared.providers.toasts.ToastType
import com.example.rentx.shared.utils.EventObserver

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var viewBinding: FragmentLoginBinding
    private lateinit var mViewModel: AuthenticationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        mViewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
        setObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            viewBinding.loginBackButton.id -> Navigation.findNavController(v)
                .navigate(R.id.action_loginFragment_to_authMenuFragment)

            viewBinding.btLogin.id -> {
                submitLogin()
            }
        }
    }

    private fun setListeners() {
        viewBinding.loginBackButton.setOnClickListener(this)
        viewBinding.btLogin.setOnClickListener(this)

        viewBinding.etEmail.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.etPassword.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
    }

    private fun setObservers(){
        mViewModel.validationSuccess.observe(viewLifecycleOwner, EventObserver{
            if(!it.getResult()){
                ToastProvider.createToast(requireContext(), ToastType.ERROR, it.getMessage())
            } else {
                activity?.let { it1 ->   HomeActivity.start(it1) }
                activity?.finish()
            }
        })
    }

    private fun submitLogin() {
        val email = viewBinding.etEmail.text.toString()
        val password = viewBinding.etPassword.text.toString()
        mViewModel.handleLogin(email, password)
    }

    private fun setButtonEnabledIfFieldsAreFilled() {
        val emailFilled = viewBinding.etEmail.text.isNotEmpty()
        val passwordFilled = viewBinding.etPassword.text.isNotEmpty()

        viewBinding.btLogin.isEnabled = emailFilled && passwordFilled
    }
}