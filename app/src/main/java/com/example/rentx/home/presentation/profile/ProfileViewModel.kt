package com.example.rentx.home.presentation.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.rentx.R

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    fun getUserName() : String {
        return "Gatinho flor"
    }

    fun getUserImage() : Int {
        return R.drawable.flower_cat
    }
}