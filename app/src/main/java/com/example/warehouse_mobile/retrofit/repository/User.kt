package com.example.warehouse_mobile.retrofit.repository

import com.example.warehouse_mobile.model.AuthenticationRequest
import com.example.warehouse_mobile.model.AuthenticationResponse
import com.example.warehouse_mobile.model.RegistrationRequest
import com.example.warehouse_mobile.model.UserRequest
import com.example.warehouse_mobile.model.userModel
import com.example.warehouse_mobile.retrofit.Api

interface UserRepository {
    suspend fun authenticate(authRequest: AuthenticationRequest): AuthenticationResponse
    suspend fun register(registrationRequest: RegistrationRequest): AuthenticationResponse
    suspend fun getUserData(token: String,userRequest: UserRequest): userModel
}

class NetworkUserRepository(
    private val api: Api
) : UserRepository {
    override suspend fun authenticate(authRequest: AuthenticationRequest): AuthenticationResponse =
        api.getAuthList(authRequest)

    override suspend fun register(registrationRequest: RegistrationRequest): AuthenticationResponse =
        api.registerNewUserApi(registrationRequest)

    override suspend fun getUserData(token: String,userRequest: UserRequest): userModel = api.getUserData(token,userRequest)
}