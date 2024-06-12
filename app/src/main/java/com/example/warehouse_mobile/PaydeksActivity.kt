package com.example.warehouse_mobile
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.warehouse_mobile.model.Courier
import com.example.warehouse_mobile.model.Paydesk
import retrofit2.Response
import com.example.warehouse_mobile.retrofit.Api

class PaydeskActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                PaydeskApp()
            }
        }
    }

    @Composable
    fun PaydeskApp() {
        var paydesks by remember { mutableStateOf(listOf<Paydesk>()) }
        val context = LocalContext.current

        LaunchedEffect(Unit) {
            ApiClient.getPaydesks(
                context,
                Response.Listener { response ->
                    paydesks = response
                },
                Response.ErrorListener { error ->
                    // Обработка на грешки
                }
            )
        }

        PaydeskList(paydesks)
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
            Text(text = "ID: ${paydesk.id}", style = MaterialTheme.typography.h6)
            Text(text = "Timestamp: ${paydesk.timestamp}", style = MaterialTheme.typography.body1)
            Text(text = "Update Counter: ${paydesk.updateCounter}", style = MaterialTheme.typography.body1)
            Text(text = "

        }