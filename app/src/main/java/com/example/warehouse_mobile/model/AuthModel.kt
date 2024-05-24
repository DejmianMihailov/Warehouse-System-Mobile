package com.example.warehouse_mobile.model

data class AuthenticationResponse(val access_token: String, val role: String)

data class AuthenticationRequest(val email: String, val password: String)

data class RegistrationRequest(
    val email: String, val password: String, val firstName: String, val lastName: String
)