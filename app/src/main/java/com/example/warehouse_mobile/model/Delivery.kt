package com.example.warehouse_mobile.model

data class DeliverySearchRequest(
    var clientName: String,
    var address: String,
    var stock: String,
    var telephone: String
)

data class DeliverySearchResponse(
    val telephone: Long,
    val address: AddressDTO,
    val stock: StockDTO,
    val client: ClientDTO
)

data class AddressDTO(val city: String, val street: String)

data class ClientDTO(val name: String)