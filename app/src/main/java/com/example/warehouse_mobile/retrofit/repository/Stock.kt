package com.example.warehouse_mobile.retrofit.repository

import com.example.warehouse_mobile.model.DeliverySearchRequest
import com.example.warehouse_mobile.model.DeliverySearchResponse
import com.example.warehouse_mobile.model.StockResponse
import com.example.warehouse_mobile.retrofit.Api

interface StockRepository {
    suspend fun getAllStock(token: String): StockResponse
    suspend fun searchDelivery(token: String, request: DeliverySearchRequest): List<DeliverySearchResponse>
}

class NetworkStockRepository(
    private val api: Api
) : StockRepository {
    override suspend fun getAllStock(token: String,): StockResponse =api.getAllStock(token)
    override suspend fun searchDelivery(
        token: String,
        request: DeliverySearchRequest
    ): List<DeliverySearchResponse> =api.searchDelivery(token,request)
}