package com.example.rentx.presentation.home.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentx.R
import com.example.rentx.shared.constants.RentXConstants
import com.example.rentx.shared.service.local.SecurityPreferences
import com.example.rentx.shared.utils.Event

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPrefs = SecurityPreferences(application)
    val logoutEvent = MutableLiveData<Event<Unit>>()

    private val mUserName = MutableLiveData<String>()
    var userName : LiveData<String> = mUserName

    fun getUserImage() : Int {
        return R.drawable.flower_cat
    }

    fun logoutUser(){
        sharedPrefs.remove(RentXConstants.SharedPrefs.USER_NAME_KEY)
        sharedPrefs.remove(RentXConstants.SharedPrefs.USER_EMAIL_KEY)
        logoutEvent.value = Event(Unit)
    }

    fun loadProfileData(){
        mUserName.value = sharedPrefs.get(RentXConstants.SharedPrefs.USER_NAME_KEY)
    }
}