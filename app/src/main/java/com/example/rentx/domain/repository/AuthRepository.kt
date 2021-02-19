package com.example.rentx.domain.repository

import com.example.rentx.data.model.UserModelData

interface AuthRepository {

    fun createUser(userModelData: UserModelData) : Long

    fun findUserByEmail(email : String) : UserModelData
}