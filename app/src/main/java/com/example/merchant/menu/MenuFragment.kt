package com.example.merchant.menu

import android.os.Bundle
import android.view.View
import com.example.merchant.R
import com.example.merchant.databinding.FragmentMenuBinding
import com.example.merchant.util.BaseFragment

class MenuFragment:BaseFragment<FragmentMenuBinding,MenuViewModel>() {


    override fun setViewModel() = MenuViewModel::class.java
    override fun bindViews() {
        binding.vm = viewModel
    }

    override fun setLayout(): Int = R.layout.fragment_menu
}