package com.example.rentx.splash.activities

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rentx.MainActivity
import com.example.rentx.R
import com.example.rentx.onboarding.activities.OnboardingActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), Animator.AnimatorListener {

    private lateinit var animationSequence: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupAnimationSequence()
        animationSequence.addListener(this)
    }

    override fun onResume() {
        super.onResume()
        animationSequence.start()
    }

    private fun setupAnimationSequence() {
        animationSequence = AnimatorSet().apply {
            playSequentially(
                setupFadeAnimation(iv_union, 1f),
                setupFadeAnimation(iv_union, 0f),
                setupFadeAnimation(iv_logo, 1f),
                setupFadeAnimation(iv_logo, 0f)
            )
        }
    }

    private fun setupFadeAnimation(target: View, value: Float): Animator {
        return ObjectAnimator.ofFloat(target, "alpha", value).apply {
            this.duration = 1500
        }
    }

    override fun onAnimationRepeat(animation: Animator?) {
        TODO("Not yet implemented")
    }

    override fun onAnimationEnd(animation: Animator) {
        startActivity(Intent(this, OnboardingActivity::class.java))
        finish()
    }

    override fun onAnimationCancel(animation: Animator) {
        animationSequence.start()
    }

    override fun onAnimationStart(animation: Animator) {
        print("animationStarted")
    }


}
