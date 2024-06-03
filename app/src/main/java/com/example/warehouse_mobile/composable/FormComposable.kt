package com.example.warehouse_mobile.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SearchShipmentForm() {
    var address by remember { mutableStateOf("") }
    var client by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }

    Column {
        Row {
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Address") }
            )
            OutlinedTextField(
                value = client,
                onValueChange = { client = it },
                label = { Text("Client") }
            )
        }
        Row {
            OutlinedTextField(
                value = stock,
                onValueChange = { stock = it },
                label = { Text("Stock") }
            )
            OutlinedTextField(
                value = telephone,
                onValueChange = { telephone = it },
                label = { Text("Thephone") }
            )
        }
        Button(onClick = { /*TODO*/ }){
            Icon(Icons.Rounded.Search, contentDescription = "Search icon")
        }
    }
}