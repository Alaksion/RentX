package com.example.rentx.presentation.home.carlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentx.R
import com.example.rentx.databinding.FragmentCarListBinding

class CarListFragment : Fragment() {

    private lateinit var carListBinding: FragmentCarListBinding
    private lateinit var mViewModel : CarListViewModel
    private lateinit var mListener : CarListListener
    private val mAdapter =
        CarListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(CarListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        carListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_car_list, container, false)

        return carListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindInfos()
        setupRecyclerView()
        setupListener()
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
    }

    private fun setupRecyclerView(){
        carListBinding.rvCarsList.layoutManager = LinearLayoutManager(context)
        carListBinding.rvCarsList.adapter = mAdapter
    }

    private fun bindInfos(){
        carListBinding.tvCarListTitle.text = mViewModel.toolBarTitle
        carListBinding.tvCarQuantity.text = mViewModel.getCarQuantityText()
    }

    private fun setupListener(){
        mListener = object :
            CarListListener {

            override fun onClick(carId: Long) {
                Toast.makeText(activity, carId.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}