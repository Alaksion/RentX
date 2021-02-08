package com.example.rentx.authentication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel (

    @PrimaryKey
    @ColumnInfo(name = "userId")
    val id : Long,

    @ColumnInfo(name = "name")
    val name : String,

    @ColumnInfo(name = "email")
    val email : String,

    @ColumnInfo(name = "password")
    val password : String

)