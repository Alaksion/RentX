package com.example.rentx.authentication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentx.authentication.data.model.UserModel
import com.example.rentx.authentication.data.repositoy.AuthRepository
import com.example.rentx.service.listeners.ValidationListener
import com.example.rentx.service.local.SharedPrefs

class AuthenticationViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = AuthRepository(application)
    private val mPrefs = SharedPrefs(application)

    private val mValidationSuccess = MutableLiveData<ValidationListener>()
    var validationSuccess : LiveData<ValidationListener> = mValidationSuccess


    fun createAccount(name: String, email: String, password: String, confirmPassword: String){

        if(!isPasswordConfirmed(password, confirmPassword)){
            mValidationSuccess.value = ValidationListener("Senhas não coincidem")
            return
        }

        if(isEmailAlreadyInUse(email)){
            mValidationSuccess.value = ValidationListener("Senhas não coincidem")
            return
        }

        val user = UserModel(0, name, email, password)
        mRepository.createUser(user)
        mValidationSuccess.value = ValidationListener()

    }

    private fun isPasswordConfirmed(password: String, confirmPassword: String) : Boolean{
        return password.equals(confirmPassword)
    }

    private fun isEmailAlreadyInUse(email: String) : Boolean{
        return this.mRepository.findUserByEmail(email) != null
    }

}