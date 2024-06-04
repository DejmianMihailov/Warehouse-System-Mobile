package com.example.warehouse_mobile.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.warehouse_mobile.view.UserViewModel

@Composable
fun CrateNewUser(userViewModel: UserViewModel) {
    Column {
        CreateUserForm(userViewModel)
    }
}