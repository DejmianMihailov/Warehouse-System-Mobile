package com.example.warehouse_mobile.data

import com.example.warehouse_mobile.model.StockResponse
import retrofit2.Retrofit
import com.example.warehouse_mobile.retrofit.Api
import com.example.warehouse_mobile.retrofit.repository.NetworkStockRepository
import com.example.warehouse_mobile.retrofit.repository.NetworkUserRepository
import com.example.warehouse_mobile.retrofit.repository.StockRepository
import com.example.warehouse_mobile.retrofit.repository.UserRepository
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val userRepository: UserRepository
    val stockResponse:StockRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "http://192.168.0.105:8081/"

    private val retrofit: Retrofit = Retrofit.Builder()
        // .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: Api by lazy {
        retrofit.create(Api::class.java)
    }

    override val userRepository: UserRepository by lazy {
        NetworkUserRepository(retrofitService)
    }
    override val stockResponse: StockRepository by lazy {
        NetworkStockRepository(retrofitService)
    }

}


