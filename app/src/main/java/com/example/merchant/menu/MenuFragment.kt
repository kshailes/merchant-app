package com.example.merchant.menu

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.merchant.DummyBackendDb
import com.example.merchant.R
import com.example.merchant.databinding.FragmentMenuBinding
import com.example.merchant.entity.Item
import com.example.merchant.util.BaseFragment
import com.example.merchant.util.CommonAdapter

class MenuFragment:BaseFragment<FragmentMenuBinding,MenuViewModel>() {


    override fun setViewModel() = MenuViewModel::class.java
    override fun bindViews() {
        binding.vm = viewModel

        val items = mutableListOf<MenuItemViewModel>()
        DummyBackendDb.getItemsAdded().forEach {
            items.add(MenuItemViewModel(it.name, it.price.toString()))
        }
        val adapter = CommonAdapter(items)
        binding.rvListOfItems.adapter = adapter

        viewModel.addNewItemClickEvent.observe(viewLifecycleOwner, {
            findNavController().navigate(R.id.add_item_fragment)
        })
    }

    override fun setLayout(): Int = R.layout.fragment_menu
}