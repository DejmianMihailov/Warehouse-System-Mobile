package com.example.warehouse_mobile.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.warehouse_mobile.ui.theme.WarehouseMobileTheme
import com.example.warehouse_mobile.view.UserViewModel

@Composable
fun StockCoposable(userViewModel: UserViewModel) {
    userViewModel.getStocks()
    var stock = userViewModel.stockDateState.collectAsState()
    WarehouseMobileTheme {
        Column {
            Spacer(modifier = Modifier.height(76.dp))
            Spacer(modifier = Modifier.width(25.dp))
            LazyColumn {
                items(stock.value.stock) { stocki ->
                    Column {
                        Row {
                            Text(text = stocki.name)
                        }
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}