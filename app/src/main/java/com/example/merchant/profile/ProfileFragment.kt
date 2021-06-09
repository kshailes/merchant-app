package com.example.merchant.profile

import com.example.merchant.R
import com.example.merchant.databinding.FragmentProfileBinding
import com.example.merchant.orders.OrderViewModel
import com.example.merchant.util.BaseFragment

class ProfileFragment:BaseFragment<FragmentProfileBinding, ProfileViewModel>() {


    override fun setViewModel() = ProfileViewModel::class.java
    override fun bindViews() {
        binding.vm = viewModel
    }

    override fun setLayout(): Int = R.layout.fragment_profile
}