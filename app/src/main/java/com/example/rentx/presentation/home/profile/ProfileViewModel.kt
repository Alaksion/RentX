package com.example.rentx.presentation.home.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentx.R
import com.example.rentx.data.model.UserModelData
import com.example.rentx.domain.usecase.UpdateEmailAndPasswordUseCase
import com.example.rentx.domain.usecase.UpdatePasswordUseCase
import com.example.rentx.shared.constants.RentXConstants
import com.example.rentx.shared.service.listeners.UseCaseListener
import com.example.rentx.shared.service.listeners.ValidationListener
import com.example.rentx.shared.service.local.SecurityPreferences
import com.example.rentx.shared.utils.Event

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPrefs = SecurityPreferences(application)
    private val updateEmailAndPasswordUseCase = UpdateEmailAndPasswordUseCase(application)
    private val updatePasswordUseCase = UpdatePasswordUseCase(application)

    val logoutEvent = MutableLiveData<Event<Unit>>()

    private val mUserName = MutableLiveData<String>()
    var userName: LiveData<String> = mUserName

    private val mEmail = MutableLiveData<String>()
    var email: LiveData<String> = mEmail

    private val mValidationListener = MutableLiveData<ValidationListener>()
    var validationListener = mValidationListener

    fun getUserImage(): Int {
        return R.drawable.flower_cat
    }

    fun logoutUser() {
        sharedPrefs.remove(RentXConstants.SharedPrefs.USER_NAME_KEY)
        sharedPrefs.remove(RentXConstants.SharedPrefs.USER_EMAIL_KEY)
        sharedPrefs.remove(RentXConstants.SharedPrefs.USER_ID_KEY)
        logoutEvent.value = Event(Unit)
    }

    fun loadProfileData() {
        mUserName.value = sharedPrefs.get(RentXConstants.SharedPrefs.USER_NAME_KEY)
        mEmail.value = sharedPrefs.get(RentXConstants.SharedPrefs.USER_EMAIL_KEY)
    }

    fun updateUsernameEmail(email: String, username: String) {
        val userId = sharedPrefs.get(RentXConstants.SharedPrefs.USER_ID_KEY).toLong()

        updateEmailAndPasswordUseCase.execute(
            userId,
            email,
            username,
            object : UseCaseListener<UserModelData> {
                override fun onSuccess(response: UserModelData) {
                    sharedPrefs.save(RentXConstants.SharedPrefs.USER_NAME_KEY, response.name)
                    mUserName.value = response.name

                    sharedPrefs.save(RentXConstants.SharedPrefs.USER_EMAIL_KEY, response.email)
                    mEmail.value = response.email

                    mValidationListener.value = ValidationListener()
                }

                override fun onError(message: String) {
                    mValidationListener.value = ValidationListener(message)
                }
            })

    }

    fun updatePassword(password: String, confirmPassword: String) {
        val userId = sharedPrefs.get(RentXConstants.SharedPrefs.USER_ID_KEY).toLong()

        updatePasswordUseCase.execute(
            password,
            confirmPassword,
            userId,
            object : UseCaseListener<Unit> {
                override fun onSuccess(response: Unit) {
                    mValidationListener.value = ValidationListener()
                }

                override fun onError(message: String) {
                    mValidationListener.value = ValidationListener(message)
                }
            })
    }
}