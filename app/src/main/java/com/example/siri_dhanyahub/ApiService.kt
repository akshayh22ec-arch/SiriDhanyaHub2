package com.example.siri_dhanyahub

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("prices")
    fun getPrices(): Call<List<MarketPrice>>
}