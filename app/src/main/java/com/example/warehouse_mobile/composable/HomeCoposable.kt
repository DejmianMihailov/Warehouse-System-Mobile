package com.example.warehouse_mobile.composable

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AllInbox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Button(onClick = { navController.navigate("profile") }) {
                    Icon(Icons.Rounded.AccountCircle, contentDescription = "Profile icon")
                }

                OutlinedButton(onClick = { navController.navigate("stock") }) {
                    Column {
                        //Text(text = "Stock")
                        //Icon(Icons.Rounded.AllInbox, contentDescription = "Stock icon")
                        Image(
                            painter = painterResource(id = R.drawable.stock1),
                            contentDescription = "Stock image button",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(300.dp).clip(CircleShape)
                        )
                    }
                }
            }
        }

    }

}