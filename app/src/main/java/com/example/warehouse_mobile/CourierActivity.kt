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

class CourierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourierApp()
        }
    }
}

@Composable
fun CourierApp() {
    var couriers by remember { mutableStateOf(listOf<Courier>()) }
    val context = LocalContext.current

    /*LaunchedEffect(Unit) {
        ApiClient.getCouriers(
            context,
            Response.Listener { response ->
                couriers = response
            },
            Response.ErrorListener { error ->

            }
        )
    }*/

    CourierList(couriers)
}

@Composable
fun CourierList(couriers: List<Courier>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(couriers) { courier ->
            CourierItem(courier)
        }
    }
}

@Composable
fun CourierItem(courier: Courier) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "Name: ${courier.name}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Address: ${courier.address}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Phone: ${courier.phoneNumber}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Email: ${courier.email}", style = MaterialTheme.typography.bodyMedium)
    }
}


@Composable
fun DefaultPreview() {
    CourierApp()
}
