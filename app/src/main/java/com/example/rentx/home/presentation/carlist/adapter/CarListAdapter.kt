package com.example.rentx.home.presentation.carlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rentx.R
import com.example.rentx.home.presentation.carlist.listener.CarListListener
import com.example.rentx.home.presentation.carlist.viewholder.CarListViewHolder
import com.example.rentx.model.CarFuelType
import com.example.rentx.model.CarModel

class CarListAdapter : RecyclerView.Adapter<CarListViewHolder>() {


    private val carMock = CarModel(
        "Audi",
        "Coupe R5",
        120.00,
        "",
        CarFuelType.Electric
    )

    private val carMock2 = CarModel(
        "Audi",
        "Coupe R5",
        120.00,
        "",
        CarFuelType.Gasoline
    )

    private var mCarsList: List<CarModel> = arrayListOf(carMock, carMock2, carMock, carMock2)
    private lateinit var mListener: CarListListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.car_list_card, parent, false)
        return CarListViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mCarsList.size
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        holder.bindData(mCarsList[position])
    }

    fun attachListener(listener: CarListListener) {
        mListener = listener
    }

    fun refreshListData(list: List<CarModel>) {
        mCarsList = list
        notifyDataSetChanged()
    }
}