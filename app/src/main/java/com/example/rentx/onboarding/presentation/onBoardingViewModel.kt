package com.example.rentx.onboarding.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentx.shared.constants.RentXConstants
import com.example.rentx.shared.service.local.SecurityPreferences

class OnBoardingViewModel(application: Application) : AndroidViewModel(application) {

    private var mSecurityPreferences = SecurityPreferences(application)

    private var mIsUserLogged = MutableLiveData<Boolean>()
    var isUserLogged: LiveData<Boolean> = mIsUserLogged


    fun verifyUserLogged() {
        val isUserEmailAvailable =
            mSecurityPreferences.get(RentXConstants.SharedPrefs.USER_EMAIL_KEY).isNotEmpty()
        val isUserNameAvailable =
            mSecurityPreferences.get(RentXConstants.SharedPrefs.USER_NAME_KEY).isNotEmpty()

        mIsUserLogged.value = isUserEmailAvailable && isUserNameAvailable
    }
}
