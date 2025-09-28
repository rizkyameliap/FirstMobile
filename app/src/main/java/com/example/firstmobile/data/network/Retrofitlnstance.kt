package com.example.firstmobile.data.network

import com.example.firstmobile.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitlnstance {
    val api: OpenLibraryApi by lazy{
        Retrofit.Builder()
            .baseUrl( Constants.BASE_URL)
            .addConverterFactory( GsonConverterFactory.create())
            .build()
            .create(OpenLibraryApi::class.java)
    }
}