package com.example.rentx.presentation.home.profile.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.rentx.presentation.home.profile.UpdateEmailUsernameFragment
import com.example.rentx.presentation.home.profile.UpdatePasswordFragment

class ProfileFragmentPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            UpdateEmailUsernameFragment()
        } else {
            UpdatePasswordFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            "Dados"
        } else {
            "Senha"
        }
    }

    companion object {
        const val ARG_OBJECT = "object"
    }


}