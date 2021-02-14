package com.example.rentx.presentation.authentication.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.rentx.R

import com.example.rentx.presentation.authentication.AuthenticationViewModel
import com.example.rentx.databinding.FragmentRegisterEmailBinding
import com.example.rentx.shared.providers.toasts.ToastProvider
import com.example.rentx.shared.providers.toasts.ToastType
import com.example.rentx.shared.utils.EventObserver
import kotlinx.android.synthetic.main.fragment_register_email.*


class RegisterFragment : Fragment(), View.OnClickListener {

    private lateinit var viewBinding: FragmentRegisterEmailBinding
    private lateinit var mViewModel: AuthenticationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register_email, container, false)
        mViewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        setUpObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            viewBinding.btRegisterMailNext.id -> {
                handleSubmitMail()
            }

            viewBinding.registerMailGoBack.id ->
                Navigation.findNavController(v)
                    .navigate(R.id.action_registerFragment_to_authMenuFragment)

        }
    }

    private fun setupListeners() {
        bt_register_mail_next.setOnClickListener(this)
        register_mail_go_back.setOnClickListener(this)

        viewBinding.etRegisterEmail.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.etRegisterName.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
    }

    private fun setUpObservers() {
        mViewModel.validationSuccess.observe(viewLifecycleOwner, EventObserver {
            if (!it.getResult()) {
                ToastProvider.createToast(requireContext(), ToastType.ERROR, it.getMessage())
            } else {
                handleNavigateToPasswordScreen(viewBinding.btRegisterMailNext)
            }
        })
    }

    private fun handleNavigateToPasswordScreen(v: View) {
        val email = viewBinding.etRegisterEmail.text.toString()
        val name = viewBinding.etRegisterName.text.toString()

        val destination =
            RegisterFragmentDirections.actionRegisterFragmentToRegisterPasswordFragment(
                email,
                name
            )

        v.findNavController().navigate(destination)
    }

    private fun handleSubmitMail() {
        this.mViewModel.isEmailAlreadyInUse(viewBinding.etRegisterEmail.text.toString())
    }

    private fun setButtonEnabledIfFieldsAreFilled() {
        val isEmailFilled = viewBinding.etRegisterEmail.text.isNotEmpty()
        val isNameFilled = viewBinding.etRegisterName.text.isNotEmpty()

        viewBinding.btRegisterMailNext.isEnabled = isEmailFilled && isNameFilled
    }
}