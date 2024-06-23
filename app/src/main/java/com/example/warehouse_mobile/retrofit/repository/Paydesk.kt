package com.example.warehouse_mobile.retrofit.repository

import com.example.warehouse_mobile.model.Paydesk
import com.example.warehouse_mobile.retrofit.Api

interface PaydeskRepository {
    suspend fun getPaydesk(token: String,): List<Paydesk>
}

class NetworkPaydeskRepository(
    private val api: Api
) : PaydeskRepository {
    override suspend fun getPaydesk(token: String): List<Paydesk> =api.getAllPaydesks(token)
}