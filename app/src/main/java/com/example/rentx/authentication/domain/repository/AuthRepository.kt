package com.example.rentx.authentication.domain.repository

import com.example.rentx.authentication.data.model.UserModelData

interface AuthRepository {

    fun createUser(userModelData: UserModelData) : Long

    fun findUserByEmail(email : String) : UserModelData
}