package com.example.rentx.presentation.authentication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentx.R

class AuthenticationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContentView(R.layout.activity_authentication)
    }
    companion object {
        fun start(activity : Activity){
            val intent = Intent(activity, AuthenticationActivity::class.java)
            activity.startActivity(intent)
        }
    }
}