package com.example.warehouse_mobile.retrofit

import com.example.warehouse_mobile.model.AuthenticationRequest
import com.example.warehouse_mobile.model.AuthenticationResponse
import com.example.warehouse_mobile.model.DeliverySearchRequest
import com.example.warehouse_mobile.model.DeliverySearchResponse
import com.example.warehouse_mobile.model.Paydesk
import com.example.warehouse_mobile.model.RegistrationRequest
import com.example.warehouse_mobile.model.StockResponse
import com.example.warehouse_mobile.model.UserRequest
import com.example.warehouse_mobile.model.userModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface Api {
    //Auth Apis
    @POST("api/vi/auth/authenticate")
    suspend fun getAuthList(@Body authRequest: AuthenticationRequest): AuthenticationResponse

    @POST("api/vi/auth/register")
    suspend fun registerNewUserApi(@Body regRequest: RegistrationRequest): AuthenticationResponse

    //User Apis
    @GET("api/vi/user")
    suspend fun getUserData(
        @Header("Authorization") token: String,
        @Body userRequest: UserRequest
    ): userModel

    @GET("api/vi/user/data")
    suspend fun getUserDataByToken(@Header("Authorization") token: String): userModel

    //Stock Apis
    @GET("api/vi/stock")
    suspend fun getAllStock(@Header("Authorization") token: String): StockResponse

    //PayDesk
    @GET("api/vi/paydesks")
    suspend fun getAllPaydesks(@Header("Authorization") token: String): List<Paydesk>

    //delivery
    @POST("/api/vi/delivery")
    suspend fun searchDelivery(
        @Header("Authorization") token: String,
        @Body request: DeliverySearchRequest
    ): List<DeliverySearchResponse>

}

