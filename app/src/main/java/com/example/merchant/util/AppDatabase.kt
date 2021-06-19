package com.example.merchant.util

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.merchant.User
import com.example.merchant.dao.ItemDao
import com.example.merchant.entity.Item

const val DATABASE_NAME = "mydb.db"
const val DATABASE_VERSION = 1


@Database(
    entities = [Item::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}