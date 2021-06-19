package com.example.merchant.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.merchant.appconstants.ColumnNames
import com.example.merchant.util.BaseEntity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Item")
class Item : BaseEntity() {
    @ColumnInfo(name = ColumnNames.Item.NAME, typeAffinity = ColumnInfo.TEXT, index = true)
    @SerializedName(ColumnNames.Item.NAME)
    lateinit var name: String

    //TODO price should be long or double. CWD
    @ColumnInfo(name = ColumnNames.Item.PRICE, typeAffinity = ColumnInfo.INTEGER, index = true)
    @SerializedName(ColumnNames.Item.PRICE)
    var price: Long = 0

    @ColumnInfo(name = ColumnNames.Item.UNIT, typeAffinity = ColumnInfo.TEXT, index = true)
    @SerializedName(ColumnNames.Item.UNIT)
    lateinit var unit: String

    @ColumnInfo(name = ColumnNames.Item.DESCRIPTION, typeAffinity = ColumnInfo.TEXT, index = true)
    @SerializedName(ColumnNames.Item.DESCRIPTION)
    lateinit var description: String
}