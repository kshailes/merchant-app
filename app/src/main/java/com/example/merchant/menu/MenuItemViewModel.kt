package com.example.merchant.menu

import com.example.merchant.R
import com.example.merchant.util.ItemViewModel

class MenuItemViewModel(val name: String, val price: String) : ItemViewModel {
    override val viewType: Int
        get() = R.layout.item_order
}