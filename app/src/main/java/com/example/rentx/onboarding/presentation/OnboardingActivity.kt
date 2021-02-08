package com.example.rentx.onboarding.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentx.R

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContentView(R.layout.activity_onboarding)
    }

    companion object{
        fun start(activity: Activity){
            val intent = Intent(activity, OnboardingActivity::class.java)
            activity.startActivity(intent)
        }
    }
}