package com.example.rentx.presentation.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.rentx.R
import com.example.rentx.databinding.FragmentUpdatePasswordBinding

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
    }

    private fun setButtonEnabledIfFieldsAreFilled() {
        val isPasswordFilled = viewBinding.etPassword.text.isNotEmpty()
        val isConfirmPasswordFilled = viewBinding.etConfirmPassword.text.isNotEmpty()

        viewBinding.btLogin.isEnabled = isPasswordFilled && isConfirmPasswordFilled
    }

    private fun setupListeners() {
        viewBinding.etPassword.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
        viewBinding.etConfirmPassword.doAfterTextChanged { setButtonEnabledIfFieldsAreFilled() }
    }

    companion object {
        const val TAB_NAME = "Senha"
    }
}