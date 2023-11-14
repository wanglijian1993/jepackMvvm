package com.example.myjepckmvvm.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RequestService {
    @GET("wxarticle/chapters/json")
    fun getDatas(): Deferred<String>
}