package com.example.rentx.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.rentx.data.model.UserModelData

@Dao
interface UserDao {

    @Query("Update UserModelData set email = :email, name = :username where userId = :userId")
    fun updateEmailAndUserName(userId: Long, email: String, username: String)

    @Query("Select * from usermodeldata where userId = :userId")
    fun findUserById(userId: Long): UserModelData
}