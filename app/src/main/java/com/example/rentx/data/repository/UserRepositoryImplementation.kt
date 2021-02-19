package com.example.rentx.data.repository

import android.content.Context
import com.example.rentx.data.model.UserModelData
import com.example.rentx.domain.repository.UserRepository
import com.example.rentx.shared.service.local.RentXDatabase
import java.lang.Exception

class UserRepositoryImplementation(context: Context) : UserRepository {

    private var mDatabase = RentXDatabase.getInstance(context)

    override fun updateEmailAndUsername(userModelData: UserModelData): UserModelData {
        try {
            mDatabase.userDao().updateEmailAndUserName(
                username = userModelData.name,
                userId = userModelData.id,
                email = userModelData.email
            )
            return userModelData
        } catch (e : Exception){
            print(e.stackTrace)
            throw e
        }

    }

    override fun updatePassword(userModelData: UserModelData) {
        return mDatabase.userDao().updatePassword(userModelData.password, userModelData.id)
    }

    override fun findUserById(userId: Long): UserModelData {
        return mDatabase.userDao().findUserById(userId)
    }
}