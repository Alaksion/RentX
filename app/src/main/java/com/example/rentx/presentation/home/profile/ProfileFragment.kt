package com.example.rentx.presentation.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rentx.R
import com.example.rentx.databinding.FragmentProfileBinding
import com.example.rentx.presentation.authentication.AuthenticationActivity
import com.example.rentx.presentation.home.profile.adapter.ProfileFragmentPagerAdapter
import com.example.rentx.shared.utils.EventObserver

class ProfileFragment : Fragment() {

    private lateinit var viewBinding: FragmentProfileBinding
    private lateinit var mViewModel: ProfileViewModel
    private lateinit var adapter : ProfileFragmentPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        mViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpListener()
        setUpPager()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.loadProfileData()
        mockProfileImage()
    }

    private fun mockProfileImage() {
        viewBinding.ivProfileImage.setImageResource(mViewModel.getUserImage())
    }

    private fun setUpObservers() {
        mViewModel.logoutEvent.observe(viewLifecycleOwner, EventObserver {
            AuthenticationActivity.start(requireActivity())
            requireActivity().finish()
        })

        mViewModel.userName.observe(viewLifecycleOwner, Observer {
            viewBinding.tvUserName.text = it
        })
    }

    private fun setUpPager(){
        adapter = ProfileFragmentPagerAdapter(childFragmentManager)
        viewBinding.vpProfile.adapter = adapter
        viewBinding.tbProfileTabs.setupWithViewPager(viewBinding.vpProfile)
    }

    private fun setUpListener(){
        viewBinding.ivLogout.setOnClickListener {
            mViewModel.logoutUser()
        }
    }
}