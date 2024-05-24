package com.example.warehouse_mobile.model

data class userModel(val firstName: String, val lastName: String, val email: String)

data class UserLogDataRequest(val email:String)

data class UserChangeStatusRequest(val userEmail:String)

data class BanResponse(val banRepost:String)

data class UserRequest(val email: String)