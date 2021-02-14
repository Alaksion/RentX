package com.example.rentx.presentation.home.carlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class CarListViewModel(application: Application) : AndroidViewModel(application) {

    val toolBarTitle = "Listagem"
    val carQuantity = 5


    fun getCarQuantityText() : String{
        return "$carQuantity carros"
    }
}