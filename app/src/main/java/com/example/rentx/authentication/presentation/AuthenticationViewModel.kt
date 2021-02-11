package com.example.rentx.authentication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentx.authentication.data.model.UserModelData
import com.example.rentx.authentication.data.repositoy.AuthRepositoryImplementation
import com.example.rentx.authentication.domain.usecase.CreateUserUseCase
import com.example.rentx.authentication.domain.usecase.ValidateDuplicatedMailUseCase
import com.example.rentx.shared.service.listeners.ValidationListener
import com.example.rentx.shared.service.local.SharedPrefs

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {

    private val mPrefs = SharedPrefs(application)

    private val createAccountUseCase = CreateUserUseCase(application)
    private val validateDuplicatedMailUseCase = ValidateDuplicatedMailUseCase(application)

    private val mValidationSuccess = MutableLiveData<ValidationListener>()
    var validationSuccess: LiveData<ValidationListener> = mValidationSuccess


    fun createAccount(name: String, email: String, password: String, confirmPassword: String) {
        mValidationSuccess.value =
            createAccountUseCase.execute(name, email, password, confirmPassword)
    }
    
    fun isEmailAlreadyInUse(email: String) {
        mValidationSuccess.value = validateDuplicatedMailUseCase.execute(email)
    }
}