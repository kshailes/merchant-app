package com.example.merchant.util

class Util {
    companion object {
        fun doubleMoneyToLongMoney(value: Double?): Long {
            value ?: return 0
            return (value * 100).toLong()
        }
    }
}