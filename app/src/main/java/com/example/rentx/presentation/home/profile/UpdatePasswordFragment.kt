package com.example.rentx.presentation.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rentx.R
import com.example.rentx.databinding.FragmentUpdatePasswordBinding
import com.example.rentx.shared.providers.toasts.ToastProvider
import com.example.rentx.shared.providers.toasts.ToastType

class UpdatePasswordFragment : Fragment() {

    private lateinit var viewBinding: FragmentUpdatePasswordBinding
    private lateinit var mViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_update_password,
            container,
            false
        )
        mViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupObservers()
    }

    private fun setButtonEnabledIfFieldsAreFilled() {
        val isPasswordFilled = viewBinding.etPassword.text.isNotEmpty()
        val isConfirmPasswordFilled = viewBinding.etConfirmPassword.text.isNotEmpty()

        viewBinding.btLogin.isEnabled = isPasswordFilled && isConfirmPasswordFilled
    }

    private fun setupListeners() {
        viewBinding.etPassword.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.etConfirmPassword.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.btLogin.setOnClickListener { handleSubmitPasswordChange() }
    }

    private fun setupObservers() {
        mViewModel.validationListener.observe(viewLifecycleOwner, Observer {
            if (!it.getResult()) {
                ToastProvider.createToast(requireContext(), ToastType.ERROR, it.getMessage())
            } else {
                ToastProvider.createToast(
                    requireContext(),
                    ToastType.SUCCESS,
                    "Informações atualizadas com sucesso"
                )
            }
        })
    }


    private fun handleSubmitPasswordChange() {
        val password = viewBinding.etPassword.text.toString()
        val confirmPassword = viewBinding.etConfirmPassword.text.toString()
        mViewModel.updatePassword(password, confirmPassword)
    }

    companion object {
        const val TAB_NAME = "Senha"
    }
}