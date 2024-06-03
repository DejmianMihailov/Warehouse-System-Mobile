package com.example.warehouse_mobile.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun TelephonePicker() {
    var selectedTelephoneNumber by remember { mutableStateOf("") }
    val telephoneNumbers = listOf("0123456789", "9876543210", "1122334455")
/*
    ExposedDropdownMenuTelephonePicker(
        selectedOption = selectedTelephoneNumber,
        onOptionSelected = { selectedTelephoneNumber = it },
        telephoneNumbers = telephoneNumbers
    )

 */
}

@Composable
fun ExposedDropdownMenuTelephonePicker(
    selectedOption: String,
    onOptionSelected: () -> Unit,
    telephoneNumbers: List<String>
) {
    TODO("Not yet implemented")
}