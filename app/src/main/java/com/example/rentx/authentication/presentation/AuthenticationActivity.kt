package com.example.rentx.authentication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentx.R

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContentView(R.layout.activity_authentication)
    }
}