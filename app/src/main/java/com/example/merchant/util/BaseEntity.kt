package com.example.merchant.util

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.merchant.appconstants.ColumnNames
import com.google.gson.annotations.SerializedName
import java.io.Serializable

abstract class BaseEntity:Serializable {
    @PrimaryKey
    @ColumnInfo(name = ColumnNames.ID, typeAffinity = ColumnInfo.TEXT, index = true)
    @SerializedName(ColumnNames.ID)
    lateinit var id: String
}