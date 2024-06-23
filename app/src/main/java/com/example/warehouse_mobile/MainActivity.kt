package com.example.warehouse_mobile

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.warehouse_mobile.composable.CrateNewUser
import com.example.warehouse_mobile.composable.HomeCoposable
import com.example.warehouse_mobile.composable.LandingCoposable
import com.example.warehouse_mobile.composable.LogInCoposable
import com.example.warehouse_mobile.composable.ProfileCoposable
import com.example.warehouse_mobile.composable.RegisterCoposable
import com.example.warehouse_mobile.composable.SearchComposable
import com.example.warehouse_mobile.composable.SearchShipment
import com.example.warehouse_mobile.composable.StockCoposable
import com.example.warehouse_mobile.ui.theme.WarehouseMobileTheme
import com.example.warehouse_mobile.view.UserViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WarehouseMobileTheme {
                // A surface container using the 'background' color from the theme
                val userViewModel: UserViewModel = viewModel(factory = UserViewModel.Factory)
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = "landing") {
                        composable("landing") {
                            LandingCoposable(navController)
                        }
                        composable("register") {
                            RegisterCoposable(userViewModel, navController)
                        }
                        composable("login") {
                            LogInCoposable(userViewModel, navController)
                        }
                        composable("home") {
                            HomeCoposable(userViewModel, navController)
                        }
                        composable("stock") {
                            StockCoposable(userViewModel)
                        }
                        composable("profile") {
                            ProfileCoposable(userViewModel)
                        }
                        composable("search") {
                            SearchComposable(userViewModel,navController)
                        }
                        composable("searchShipment") {
                            SearchShipment(userViewModel)
                        }
                        composable("createOperator") {
                            CrateNewUser(userViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WarehouseMobileTheme {
        Greeting("Android")
    }
}