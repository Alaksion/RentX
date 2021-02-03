package com.example.rentx.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentx.R

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContentView(R.layout.activity_onboarding)
    }
}