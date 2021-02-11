package com.example.rentx.authentication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rentx.authentication.data.model.UserModelData

@Dao
interface AuthenticationDao {

    @Insert
    fun createUser(userData : UserModelData) : Long

    @Query(value = "Select * from usermodeldata where email = :email")
    fun findByEmail(email : String) : UserModelData
}