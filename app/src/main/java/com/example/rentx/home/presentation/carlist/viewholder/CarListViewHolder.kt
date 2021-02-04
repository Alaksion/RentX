package com.example.rentx.home.presentation.carlist.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rentx.R
import com.example.rentx.home.presentation.carlist.listener.CarListListener
import com.example.rentx.model.CarFuelType
import com.example.rentx.model.CarModel

class CarListViewHolder(itemView: View, val listener: CarListListener) :
    RecyclerView.ViewHolder(itemView) {

    private val carModelText = itemView.findViewById<TextView>(R.id.tv_car_model)
    private val carBrandText = itemView.findViewById<TextView>(R.id.tv_car_brand)
    private val carPriceText = itemView.findViewById<TextView>(R.id.tv_car_price)
    private val carFuelImage = itemView.findViewById<ImageView>(R.id.iv_car_fuel_type)

    fun bindData(model: CarModel) {
        val carPrice = "R$ ${model.carPrice}"

        this.carBrandText.text = model.carBrand
        this.carModelText.text = model.carModel
        this.carPriceText.text = carPrice
        setCarFuelTypeIcon(model)

    }

    private fun setCarFuelTypeIcon(model : CarModel){
        carFuelImage.setImageResource(
            if(model.fuelType == CarFuelType.Electric){
                R.drawable.ic_electric
            } else {
                R.drawable.ic_gasoline
            }
        )
    }
}
