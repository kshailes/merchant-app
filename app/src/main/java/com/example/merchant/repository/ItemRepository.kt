package com.example.merchant.repository

import com.example.merchant.DummyBackendDb
import com.example.merchant.dao.ItemDao
import com.example.merchant.entity.Item
import com.example.merchant.networkapiservice.CommonApiService
import com.example.merchant.util.Network.Outcome
import com.example.merchant.util.Network.apiCall
import kotlinx.coroutines.delay
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val commonApiService: CommonApiService,
    private val itemDao: ItemDao
) {

    suspend fun addItem(item: Item): Outcome<Item> {
        return apiCall {
            commonApiService.addItem(item)
        }
    }

    suspend fun saveItem(item: Item) {
        itemDao.insertItem(item)
    }
}