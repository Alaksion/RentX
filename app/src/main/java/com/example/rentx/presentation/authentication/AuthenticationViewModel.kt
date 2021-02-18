package com.example.rentx.presentation.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentx.data.model.UserModelData
import com.example.rentx.domain.usecase.CreateUserUseCase
import com.example.rentx.domain.usecase.LoginUseCase
import com.example.rentx.domain.usecase.ValidateDuplicatedMailUseCase
import com.example.rentx.shared.constants.RentXConstants
import com.example.rentx.shared.service.listeners.UseCaseListener
import com.example.rentx.shared.service.listeners.ValidationListener
import com.example.rentx.shared.service.local.SecurityPreferences
import com.example.rentx.shared.utils.Event

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {

    private val mPrefs = SecurityPreferences(application)

    private val createAccountUseCase =
        CreateUserUseCase(application)
    private val validateDuplicatedMailUseCase =
        ValidateDuplicatedMailUseCase(
            application
        )
    private val loginUseCase =
        LoginUseCase(application)

    private val mValidationSuccess = MutableLiveData<Event<ValidationListener>>()
    var validationSuccess: LiveData<Event<ValidationListener>> = mValidationSuccess


    fun createAccount(name: String, email: String, password: String, confirmPassword: String) {

        createAccountUseCase.execute(
            name,
            email,
            password,
            confirmPassword,
            object : UseCaseListener<Long> {
                override fun onSuccess(response: Long) {
                    mValidationSuccess.value = Event(ValidationListener())
                }

                override fun onError(message: String) {
                    mValidationSuccess.value = Event(ValidationListener(message))
                }

            })
    }

    fun isEmailAlreadyInUse(email: String) {
        validateDuplicatedMailUseCase.execute(email, object : UseCaseListener<Long> {
            override fun onSuccess(response: Long) {
                mValidationSuccess.value = Event(ValidationListener())
            }

            override fun onError(message: String) {
                mValidationSuccess.value = Event(ValidationListener(message))
            }
        })
    }

    fun handleLogin(email: String, password: String) {
        loginUseCase.execute(email, password, object : UseCaseListener<UserModelData> {
            override fun onSuccess(response: UserModelData) {
                mPrefs.save(RentXConstants.SharedPrefs.USER_EMAIL_KEY, response.email)
                mPrefs.save(RentXConstants.SharedPrefs.USER_NAME_KEY, response.name)

                mValidationSuccess.value = Event(ValidationListener())
            }

            override fun onError(message: String) {
                mValidationSuccess.value = Event(ValidationListener(message))
            }

        })
    }
}