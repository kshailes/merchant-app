package com.example.merchant

import com.example.merchant.entity.Item
import kotlinx.coroutines.delay
import java.util.*

object DummyBackendDb {
    private val listOfItems = mutableListOf<Item>()

    suspend fun saveItem(item: Item): Item {
        delay(1000)
        item.id = UUID.randomUUID().toString()
        listOfItems.add(item)
        return item
    }

    fun getItemsAdded(): List<Item> {
        return listOfItems
    }
}