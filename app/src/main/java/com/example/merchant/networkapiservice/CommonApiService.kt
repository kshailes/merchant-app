package com.example.merchant.networkapiservice

import com.example.merchant.entity.Item
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CommonApiService {
    @POST("item")
    suspend fun addItem(@Body item:Item): Response<Item>

}