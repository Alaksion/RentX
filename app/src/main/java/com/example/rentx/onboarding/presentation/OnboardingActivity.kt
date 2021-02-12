package com.example.rentx.onboarding.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rentx.R
import com.example.rentx.home.presentation.HomeActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var mViewModel: OnBoardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(this).get(OnBoardingViewModel::class.java)
        setContentView(R.layout.activity_onboarding)
        setUpObservers()
        mViewModel.verifyUserLogged()
    }

    private fun setUpObservers(){
        mViewModel.isUserLogged.observe(this, Observer {
            if(it){
                HomeActivity.start(this)
                finish()
            }
        })
    }

    companion object{
        fun start(activity: Activity){
            val intent = Intent(activity, OnboardingActivity::class.java)
            activity.startActivity(intent)
        }
    }
}