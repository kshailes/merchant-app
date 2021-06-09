package com.example.merchant.util

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.merchant.User

const val DATABASE_NAME = "mydb.db"
const val DATABASE_VERSION = 1


@Database(
    entities = [User::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

}