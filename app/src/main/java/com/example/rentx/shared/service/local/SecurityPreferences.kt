package com.example.rentx.shared.service.local

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private var prefs: SharedPreferences =
        context.getSharedPreferences("RentX", Context.MODE_PRIVATE)

    fun save(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }

    fun get(key: String): String {
        return prefs.getString(key, "") ?: ""
    }
}