package com.terra.mobile.retrofit.repository

import com.example.warehouse_mobile.model.AuthenticationRequest
import com.example.warehouse_mobile.model.AuthenticationResponse
import com.example.warehouse_mobile.model.BanResponse
import com.example.warehouse_mobile.model.LoginDataDTO
import com.example.warehouse_mobile.model.LoginDataRequest
import com.example.warehouse_mobile.model.LoginDataResponse
import com.example.warehouse_mobile.model.RegistrationRequest
import com.example.warehouse_mobile.model.UserChangeStatusRequest
import com.example.warehouse_mobile.model.UserLogDataRequest
import com.example.warehouse_mobile.model.userModel
import com.example.warehouse_mobile.retrofit.Api

interface UserRepository {
    suspend fun authenticate(authRequest: AuthenticationRequest): AuthenticationResponse
    suspend fun register(registrationRequest: RegistrationRequest): AuthenticationResponse
    suspend fun getUserData(token: String): userModel
    suspend fun getLogData(token: String, loginDataRequest: LoginDataRequest): LoginDataResponse
    suspend fun getAllUserData(token: String): List<userModel>
    suspend fun  getAllBanedUserData(token: String): List<userModel>
    suspend fun getAllUserByMailData(
        teken: String,
        userData: UserLogDataRequest
    ): List<LoginDataDTO>

    suspend fun banUser(
        teken: String,
        userData: UserChangeStatusRequest
    ): BanResponse

    suspend fun unBanUser(
        teken: String,
        userData: UserChangeStatusRequest
    ): BanResponse
}

class NetworkUserRepository(
    private val api: Api
) : UserRepository {
    override suspend fun authenticate(authRequest: AuthenticationRequest): AuthenticationResponse =
        api.getAuthList(authRequest)

    override suspend fun register(registrationRequest: RegistrationRequest): AuthenticationResponse =
        api.registerNewUserApi(registrationRequest)

    override suspend fun getUserData(token: String): userModel = api.getUserData(token)

    override suspend fun getLogData(
        token: String,
        loginDataRequest: LoginDataRequest
    ): LoginDataResponse = api.getLgData(token, loginDataRequest)

    override suspend fun getAllUserData(token: String): List<userModel> = api.getAllUserData(token)
    override suspend fun getAllBanedUserData(token: String): List<userModel> =api.allBanedUsers(token)
    override suspend fun getAllUserByMailData(
        teken: String,
        userData: UserLogDataRequest
    ): List<LoginDataDTO> = api.getAllUserByMailData(teken, userData)

    override suspend fun banUser(teken: String, userData: UserChangeStatusRequest): BanResponse =
        api.banUser(teken, userData)

    override suspend fun unBanUser(teken: String, userData: UserChangeStatusRequest): BanResponse =
        api.unBanUser(teken, userData)
}