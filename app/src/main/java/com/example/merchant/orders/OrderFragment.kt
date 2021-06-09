package com.example.merchant.orders

import com.example.merchant.R
import com.example.merchant.databinding.FragmentMenuBinding
import com.example.merchant.databinding.FragmentOrderBinding
import com.example.merchant.menu.MenuViewModel
import com.example.merchant.util.BaseFragment

class OrderFragment:BaseFragment<FragmentOrderBinding, OrderViewModel>() {


    override fun setViewModel() = OrderViewModel::class.java
    override fun bindViews() {
        binding.vm = viewModel
    }

    override fun setLayout(): Int = R.layout.fragment_order
}