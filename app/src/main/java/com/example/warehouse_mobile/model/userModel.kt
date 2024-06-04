package com.example.warehouse_mobile.model

data class userModel(val firstName: String, val lastName: String, val email: String, val role:String)

data class UserRequest(val email: String)