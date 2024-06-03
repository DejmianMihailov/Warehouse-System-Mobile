package com.example.warehouse_mobile.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.DeliveryDining
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.warehouse_mobile.view.UserViewModel

@Composable
fun SearchComposable(userModel: UserViewModel, navController: NavHostController) {
    Column {
        Button(onClick = { navController.navigate("searchShipment") }) {
            Icon(Icons.Rounded.DeliveryDining, contentDescription = "Profile icon")
        }
    }
}

@Composable
fun SearchShipment(userViewModel: UserViewModel) {
    Column {
        Text(text = "Shipments")
    }
}