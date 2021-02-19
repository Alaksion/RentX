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
import com.example.rentx.databinding.FragmentUpdateEmailUsernameBinding
import com.example.rentx.shared.providers.toasts.ToastProvider
import com.example.rentx.shared.providers.toasts.ToastType
import com.example.rentx.shared.utils.EventObserver

class UpdateEmailUsernameFragment : Fragment() {

    private lateinit var viewBinding: FragmentUpdateEmailUsernameBinding
    private lateinit var mViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_update_email_username,
            container,
            false
        )
        mViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setUpObservers()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.loadProfileData()
    }

    private fun setButtonEnabledIfFieldsAreFilled() {
        val isEmailFilled = viewBinding.etEmail.text.isNotEmpty()
        val isUserNameFilled = viewBinding.etUsername.text.isNotEmpty()

        viewBinding.btLogin.isEnabled = isEmailFilled && isUserNameFilled
    }

    private fun setupListeners() {
        viewBinding.etEmail.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.etUsername.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.btLogin.setOnClickListener {
            handleSubmitUpdate()
        }
    }

    private fun setUpObservers() {
        mViewModel.userName.observe(viewLifecycleOwner, Observer {
            viewBinding.etUsername.setText(it)
        })

        mViewModel.email.observe(viewLifecycleOwner, Observer {
            viewBinding.etEmail.setText(it)
        })

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

    private fun handleSubmitUpdate() {
        val email = viewBinding.etEmail.text.toString()
        val username = viewBinding.etUsername.text.toString()
        mViewModel.updateUsernameEmail(email, username)
    }


    companion object {
        const val TAB_NAME = "Dados"
    }
}