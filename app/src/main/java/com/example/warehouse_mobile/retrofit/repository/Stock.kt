package com.example.warehouse_mobile.retrofit.repository

import com.example.warehouse_mobile.model.StockResponse
import com.example.warehouse_mobile.retrofit.Api

interface StockRepository {
    suspend fun getAllStock(token: String,): StockResponse
}

class NetworkStockRepository(
    private val api: Api
) : StockRepository {
    override suspend fun getAllStock(token: String,): StockResponse =api.getAllStock(token)
}