package com.example.warehouse_mobile.composable

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.warehouse_mobile.data.UserState
import com.example.warehouse_mobile.view.UserViewModel

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeCoposable(
    userModel: UserViewModel?
) {
    if (userModel != null) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(text = "Ko staaa A")
            if (userModel.userUiState is UserState.Success) {
                //userModel.getUserData()

            }
        }

    }

}