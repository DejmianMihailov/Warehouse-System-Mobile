package com.example.warehouse_mobile.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.warehouse_mobile.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun LandingCoposable( navController: NavHostController) {
        Box(modifier = with(Modifier) {
            fillMaxHeight().paint(
                    painterResource(id = R.drawable.loginimg),
                    contentScale = ContentScale.FillHeight,
                    colorFilter = ColorFilter.tint(Color.Gray, blendMode = BlendMode.Darken)
                )

        }) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Warehouse",
                    fontSize = TextUnit(12f, TextUnitType.Em),
                   // fontFamily = FontFamily(Font(R.font.bowlby_one)),
                    color = WarehouseDarkBlue
                )
                Button(
                    onClick = { navController.navigate("login") }, modifier = Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(WarehouseWhite),
                ) { Text(text = "Log In", color = Color.Black)}
                Button(
                    onClick = { navController.navigate("register") }, modifier = Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(WarehouseWhite),
                ) { Text(text = "Register", color = Color.Black)}
            }
        }

}