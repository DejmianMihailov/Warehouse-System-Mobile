package com.example.warehouse_mobile.composable

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.example.warehouse_mobile.R
import com.example.warehouse_mobile.view.UserViewModel


val WarehouseWhite: Color = Color(242, 231, 220)
val WarehouseDarkBlue: Color = Color(18, 224, 189)


@SuppressLint("UnrememberedMutableState")
@Composable
fun LogInCoposable(viewModel: UserViewModel?, navController: NavHostController) {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val isTextFieldEmpty by derivedStateOf {
        userName.isBlank()
    }
    val isTextFieldEmptyPassword by derivedStateOf {
        password.isBlank()
    }
        Box(
            modifier = with(Modifier) {
                fillMaxHeight()
                    .paint(
                        painterResource(id = R.drawable.loginimg),
                        contentScale = ContentScale.FillHeight,
                        colorFilter = ColorFilter.tint(Color.Gray, blendMode = BlendMode.Darken)
                    )

            })
        {
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
                    //fontFamily = FontFamily(Font(R.font)),
                    color = WarehouseDarkBlue
                )
                TextField(
                    value = userName,
                    modifier = Modifier.background(WarehouseWhite),
                    onValueChange = { userName = it },
                    label = { Text("Enter email") }
                )
                TextField(
                    value = password,
                    modifier = Modifier.background(WarehouseWhite),
                    onValueChange = { password = it },
                    label = { Text("Enter password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                if (isTextFieldEmpty) {
                    Text("Please enter text", color = Color.Red)
                }
                Button(
                    onClick = {
                        if (!isTextFieldEmpty && !isTextFieldEmptyPassword) {
                            loading = true

                            if (viewModel != null) {
                                logInAction(
                                    viewModel,
                                    userName,
                                    password,
                                    navController
                                ) { progress ->
                                    currentProgress = progress
                                }
                            }
                            loading = false
                        }
                    },
                    modifier = Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(WarehouseWhite),
                )
                {
                    Text(text = "Log in", color = Color.Black)

                }
                DevLogInButtonComposable(viewModel,navController)
            }
        }

}


@Composable
fun DevLogInButtonComposable(viewModel: UserViewModel?, navController: NavHostController){
    Button(
        onClick = {
            if (viewModel != null) {
                logInAction(
                    viewModel,
                    "DamyanAdmin@mail.com",
                    "12345678",
                    navController
                ) {}
            }
        },
        modifier = Modifier.padding(10.dp), colors = ButtonDefaults.buttonColors(
            Color.Transparent,
            Color.Transparent, Color.Transparent, Color.Transparent
        )
    )
    {
        Text(text = "Log in")
    }
}

private fun logInAction(
    viewModel: UserViewModel,
    email: String,
    password: String,
    navController: NavHostController,
    updateProgress: (Float) -> Unit
) {
    Log.w("logInAction", "logInAction")
    updateProgress(40F)
    viewModel.logUser(email, password, navController)
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LogInCoposable(viewModel = null, navController = navController)
}

