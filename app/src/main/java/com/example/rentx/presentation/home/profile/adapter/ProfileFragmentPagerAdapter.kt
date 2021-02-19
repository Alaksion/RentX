package com.example.rentx.presentation.home.profile.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.room.Update
import com.example.rentx.presentation.home.profile.UpdateEmailUsernameFragment
import com.example.rentx.presentation.home.profile.UpdatePasswordFragment

class ProfileFragmentPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val tabFragmentList =
        arrayListOf(UpdateEmailUsernameFragment(), UpdatePasswordFragment())

    override fun getItem(position: Int): Fragment {
        return tabFragmentList[position]
    }

    override fun getCount(): Int {
        return tabFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            UpdateEmailUsernameFragment.TAB_NAME
        } else {
            UpdatePasswordFragment.TAB_NAME
        }
    }
}