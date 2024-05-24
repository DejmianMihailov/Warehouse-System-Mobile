package com.example.warehouse_mobile.data

import com.example.warehouse_mobile.model.AuthenticationResponse

sealed interface UserState {
    data class Success(val authResponse: AuthenticationResponse) : UserState {
        fun getTokken():String{
            return authResponse.access_token
        }
        fun getRole():String{
            return authResponse.role
        }
    }
    object Error : UserState
    object Loading : UserState
}
