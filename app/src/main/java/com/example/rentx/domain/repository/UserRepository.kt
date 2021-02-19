package com.example.rentx.domain.repository

import com.example.rentx.data.model.UserModelData

interface UserRepository {

    fun updateEmailAndUsername(userModelData: UserModelData) : UserModelData

    fun updatePassword(userModelData: UserModelData)

    fun findUserById(userId: Long) : UserModelData
}