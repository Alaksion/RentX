package com.example.rentx.authentication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rentx.authentication.data.model.UserModel

@Dao
interface AuthenticationDao {

    @Insert
    fun createUser(user : UserModel) : Long

    @Query(value = "Select * from usermodel where email = :email")
    fun findByEmail(email : String) : UserModel
}