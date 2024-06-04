package com.example.warehouse_mobile.view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import com.example.warehouse_mobile.AppActivity
import com.example.warehouse_mobile.data.UserState
import com.example.warehouse_mobile.model.AuthenticationRequest
import com.example.warehouse_mobile.model.RegistrationRequest
import com.example.warehouse_mobile.model.StockResponse
import com.example.warehouse_mobile.model.UserRequest
import com.example.warehouse_mobile.model.userModel
import com.example.warehouse_mobile.retrofit.repository.StockRepository
import com.example.warehouse_mobile.retrofit.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UserViewModel(
    private val userRepository: UserRepository,
    private val stockRepository: StockRepository
) : ViewModel() {
    var userUiState: UserState by mutableStateOf(UserState.Loading)
    //var userData: UserModel by mutableStateOf(UserModel("", "", ""))

    private val _userData = MutableStateFlow<userModel>(userModel("", "", "", ""))
    val userData: StateFlow<userModel> = _userData

    private val _stockDate = MutableStateFlow<StockResponse>(StockResponse(emptyList()))
    val stockDateState: StateFlow<StockResponse> = _stockDate

    private val _superAdminUserData = MutableStateFlow<List<userModel>>(emptyList())
    val superAdminUserData: StateFlow<List<userModel>> = _superAdminUserData

    private val _superAdminBanedUserData = MutableStateFlow<List<userModel>>(emptyList())
    val superAdminBanedUserData: StateFlow<List<userModel>> = _superAdminBanedUserData

    fun getUserData() {
        viewModelScope.launch {
            if (userUiState is UserState.Success) {
                val authToken = "Bearer " + (userUiState as UserState.Success).getTokken()
                val foudUserData = userRepository.getUserData(authToken)
                if (foudUserData != null) {
                    _userData.value = foudUserData
                } else {
                    userModel("", "", "", "");
                }
                Log.w("USERDATA", userData.value.email)
            }
        }
    }

    fun logUser(email: String, password: String, navController: NavHostController) {
        viewModelScope.launch {
            userUiState = UserState.Loading
            userUiState = try {
                UserState.Success(
                    userRepository.authenticate(
                        AuthenticationRequest(
                            email, password
                        )
                    )
                )
            } catch (e: IOException) {
                UserState.Error
            } catch (e: HttpException) {
                UserState.Error
            }
            if (userUiState is UserState.Success) {
                val navstring = "home";
                navController.navigate(navstring)
            }
        }
    }

    fun addOperator(
        email: String,
        password: String,
        firsName: String,
        lastName: String,
    ): Boolean {
        try {
            viewModelScope.launch {
                userRepository.register(
                    RegistrationRequest(
                        email, password, firsName, lastName
                    )
                )
            }
        }finally {
            return true
        }
        return false
    }

    fun register(
        email: String,
        password: String,
        firsName: String,
        lastName: String,
        navController: NavHostController
    ) {
        viewModelScope.launch {
            userUiState = UserState.Loading
            userUiState = try {
                UserState.Success(
                    userRepository.register(
                        RegistrationRequest(
                            email, password, firsName, lastName
                        )
                    )
                )
            } catch (e: IOException) {
                UserState.Error
            } catch (e: HttpException) {
                UserState.Error
            }
            if (userUiState is UserState.Success) {
                val navstring = "home";
                navController.navigate(navstring)
                Log.w("USERTOKKEN", userUiState.toString())
            }
        }
    }

    fun getStocks() {
        viewModelScope.launch {
            if (userUiState is UserState.Success) {
                val authToken = "Bearer " + (userUiState as UserState.Success).getTokken()
                val foudStockData = stockRepository.getAllStock(authToken)
                if (foudStockData != null) {
                    _stockDate.value = foudStockData
                } else {
                    userModel("", "", "", "");
                }
                Log.w("STOCKData", userData.value.email)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AppActivity)
                val userRope = application.container.userRepository
                val stockRepo = application.container.stockResponse
                UserViewModel(userRope, stockRepo)
            }
        }
    }
}