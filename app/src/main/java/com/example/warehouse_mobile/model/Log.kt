package com.example.warehouse_mobile.model

data class LoginDataDTO(
    val userEmail: String,
    val token: String,
    val ipAddress: String,
    val macAddress: String,
    val date: String
)

data class LoginDataResponse(
    val page: Integer, val data: List<LoginDataDTO>
)

data class LoginDataRequest(val page: Int?)