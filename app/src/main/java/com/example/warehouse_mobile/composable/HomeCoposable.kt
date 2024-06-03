package com.example.warehouse_mobile.composable

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AllInbox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.warehouse_mobile.R
import com.example.warehouse_mobile.data.UserState
import com.example.warehouse_mobile.view.UserViewModel

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeCoposable(
    userModel: UserViewModel?,
    navController: NavHostController
) {
    if (userModel != null) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            if (userModel.userUiState is UserState.Success) {
                userModel.getUserData()
            }
            Column {
                Button(onClick = { navController.navigate("stock") }) {
                    Text(text = "Stock")
                    Icon(Icons.Rounded.AllInbox, contentDescription ="Stock icon")
                }
                Button(onClick = { navController.navigate("profile") }) {
                    Icon(Icons.Rounded.AccountCircle, contentDescription ="Profile icon")
                }
            }
        }

    }

}