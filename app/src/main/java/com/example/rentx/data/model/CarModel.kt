package com.example.rentx.data.model

data class CarModel(
    val id: Long,
    val carBrand: String,
    val carModel: String,
    val carPrice: Double,
    val imageUrl: String,
    val fuelType: CarFuelType
)