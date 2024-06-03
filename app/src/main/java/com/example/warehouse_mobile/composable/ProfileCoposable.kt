package com.example.warehouse_mobile.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.warehouse_mobile.R
import com.example.warehouse_mobile.ui.theme.WarehouseMobileTheme
import com.example.warehouse_mobile.view.UserViewModel

@Composable
fun ProfileCoposable(userModel: UserViewModel) {
    val user = userModel.userData.collectAsState()
    Column {
        Spacer(modifier = Modifier.height(13.dp))
        Spacer(modifier = Modifier.width(13.dp))
        Text(text = "First Name: ${user.value.firstName}")
        Text(text = "Last Name: ${user.value.lastName}")
        Text(text = "Email: ${user.value.email}")
    }
}