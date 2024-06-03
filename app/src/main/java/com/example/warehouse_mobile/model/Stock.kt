package com.example.warehouse_mobile.model

data class StockResponse(val stock:List<StockDTO>)
data class StockDTO(val id:Long, val name:String)