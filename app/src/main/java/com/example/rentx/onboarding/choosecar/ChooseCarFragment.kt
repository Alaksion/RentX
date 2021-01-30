package com.example.rentx.onboarding.choosecar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.rentx.MainActivity
import com.example.rentx.R
import kotlinx.android.synthetic.main.fragment_choose_car.*


class ChooseCarFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_choose_car, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        iv_car_next_screen.setOnClickListener(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            iv_car_next_screen.id -> {
                requireActivity().finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }
    }

}