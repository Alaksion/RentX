package com.example.rentx.model

data class CarModel(
    val carBrand: String,
    val carModel: String,
    val carPrice: Double,
    val imageUrl: String,
    val fuelType: CarFuelType
) {


}