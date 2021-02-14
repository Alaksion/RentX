package com.example.rentx.data.repository

import android.content.Context
import com.example.rentx.data.model.UserModelData
import com.example.rentx.domain.repository.AuthRepository
import com.example.rentx.shared.service.local.RentXDatabase

class AuthRepositoryImplementation(context: Context) :
    AuthRepository {

    private val mDatabase = RentXDatabase.getInstance(context)

    override fun createUser(userModelData: UserModelData) : Long{
        return mDatabase.authDao().createUser(userModelData)
    }

    override fun findUserByEmail(email : String) : UserModelData {
        return mDatabase.authDao().findByEmail(email)
    }
}