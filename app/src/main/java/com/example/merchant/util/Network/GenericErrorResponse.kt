package com.example.merchant.util.Network

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
open class GenericErrorResponse(
    @SerializedName("errorCode") var errorCode: String,
    @SerializedName("message") var message: String
)