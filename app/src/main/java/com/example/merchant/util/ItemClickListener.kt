package com.example.merchant.util

interface ItemClickListener<in T> {

    fun onItemClick(value: T)
}