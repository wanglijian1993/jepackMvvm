package com.example.myjepckmvvm.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    object RetrofitClient {
        val BASE_URL = "base"
        val reqApi by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return@lazy retrofit.create(RequestService::class.java)
        }
    }


}