package com.example.rentx.home.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.rentx.R
import com.example.rentx.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var viewBinding : FragmentProfileBinding
    private lateinit var mViewModel : ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()

    }

    private fun bindData(){
        viewBinding.tvUserName.text = mViewModel.getUserName()
        viewBinding.ivProfileImage.setImageResource(mViewModel.getUserImage())
    }

}