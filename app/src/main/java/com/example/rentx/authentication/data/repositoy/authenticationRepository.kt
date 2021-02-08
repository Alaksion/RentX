package com.example.rentx.authentication.data.repositoy

import android.content.Context
import com.example.rentx.authentication.data.model.UserModel
import com.example.rentx.service.local.RentXDatabase

class authenticationRepository(context: Context) {

    private val mDatabase = RentXDatabase.getInstance(context)

    fun createUser(userModel: UserModel){
        mDatabase.authDao().createUser(userModel)
    }

    fun findUserByEmail(email : String){
        mDatabase.authDao().findByEmail(email)
    }
}