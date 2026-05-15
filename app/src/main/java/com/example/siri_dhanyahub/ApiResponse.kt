package com.example.siri_dhanyahub

import com.google.gson.annotations.SerializedName

data class ApiResponse(

    @SerializedName("records")
    val records: List<MarketPrice>
)