package com.example.rentx.service.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rentx.authentication.data.dao.AuthenticationDao
import com.example.rentx.authentication.data.model.UserModel

@Database(entities = [UserModel::class], version = 2)
abstract class RentXDatabase : RoomDatabase() {

    abstract fun authDao() : AuthenticationDao

    companion object {
        private lateinit var DB_INSTANCE: RentXDatabase

        fun getInstance(context: Context): RentXDatabase {
            if (!Companion::DB_INSTANCE.isInitialized) {
                synchronized(RentXDatabase::class.java) {
                    DB_INSTANCE =
                        Room.databaseBuilder(context, RentXDatabase::class.java, "RentXDb")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return DB_INSTANCE
        }
    }

}