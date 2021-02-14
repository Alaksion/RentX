package com.example.rentx.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserModelData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    var id : Long = 0

    @ColumnInfo(name = "name")
    var name : String = ""

    @ColumnInfo(name = "email")
    var email : String = ""

    @ColumnInfo(name = "password")
    var password : String = ""

}


