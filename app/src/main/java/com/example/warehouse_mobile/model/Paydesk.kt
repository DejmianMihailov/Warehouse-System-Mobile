package com.example.warehouse_mobile.model
import java.math.BigDecimal
import java.sql.Timestamp

data class Paydesk(
    val id: Long,
    val timestamp: Timestamp,
    val updateCounter: Long,
    val money: BigDecimal
)
