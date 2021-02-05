package com.example.rentx.home.data.model

import com.example.rentx.home.data.model.CarFuelType

data class CarModel(
    val id: Long,
    val carBrand: String,
    val carModel: String,
    val carPrice: Double,
    val imageUrl: String,
    val fuelType: CarFuelType
)