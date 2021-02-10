package com.example.rentx.authentication.data.repositoy

import android.content.Context
import com.example.rentx.authentication.data.model.UserModel
import com.example.rentx.service.local.RentXDatabase

class AuthRepository(context: Context) {

    private val mDatabase = RentXDatabase.getInstance(context)

    fun createUser(userModel: UserModel) : Long{
        return mDatabase.authDao().createUser(userModel)
    }

    fun findUserByEmail(email : String) : UserModel{
        return mDatabase.authDao().findByEmail(email)
    }
}