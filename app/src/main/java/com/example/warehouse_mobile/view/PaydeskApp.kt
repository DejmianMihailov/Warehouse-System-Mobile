package com.example.warehouse_mobile.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.warehouse_mobile.model.Paydesk

@Composable
fun PaydeskApp(paydeskViewModel: UserViewModel) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        paydeskViewModel.loadPaydesks(context)
    }

    val paydesks =paydeskViewModel.paydesks.collectAsState()
    PaydeskList(paydesks.value)
}

@Composable
fun PaydeskList(paydesks: List<Paydesk>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(paydesks) { paydesk ->
            PaydeskItem(paydesk)
        }
    }
}

@Composable
fun PaydeskItem(paydesk: Paydesk) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "ID: ${paydesk.id}")
        Text(text = "Timestamp: ${paydesk.timestamp}")
        Text(text = "Update Counter: ${paydesk.updateCounter}")
    }
}
