package com.example.rentx.home.presentation.carlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class CarListViewModel(application: Application) : AndroidViewModel(application) {

    val toolBarTitle = "Listagem"
    val carQuantity = 5


    fun getCarQuantityText() : String{
        return "$carQuantity carros"
    }
}