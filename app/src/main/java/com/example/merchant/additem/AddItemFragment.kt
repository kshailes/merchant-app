package com.example.merchant.additem

import androidx.navigation.fragment.findNavController
import com.example.merchant.R
import com.example.merchant.databinding.FragmentAddItemBinding
import com.example.merchant.util.BaseFragment

class AddItemFragment : BaseFragment<FragmentAddItemBinding, AddItemViewModel>() {
    override fun bindViews() {
        binding.vm = viewModel
        viewModel.itemSavedEvent.observe(viewLifecycleOwner, {
            if(!it.hasBeenHandled) {
                findNavController().navigate(R.id.menu_fragment)
            }
        })
    }

    override fun setLayout() = R.layout.fragment_add_item

    override fun setViewModel() = AddItemViewModel::class.java
}