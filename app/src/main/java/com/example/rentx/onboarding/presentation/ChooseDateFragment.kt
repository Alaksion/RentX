package com.example.rentx.onboarding.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.rentx.R
import kotlinx.android.synthetic.main.fragment_choose_car.*
import kotlinx.android.synthetic.main.fragment_choose_date.*

class ChooseDateFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_date, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        iv_date_next_screen.setOnClickListener(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when (v.id) {
            iv_date_next_screen.id -> {
                Navigation.findNavController(v).navigate(R.id.action_next_onboarding_page)
            }
        }
    }

}