package com.example.rentx.home.presentation.carlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentx.R
import com.example.rentx.databinding.FragmentCarListBinding
import com.example.rentx.home.presentation.carlist.adapter.CarListAdapter
import com.example.rentx.home.presentation.carlist.listener.CarListListener
import kotlinx.android.synthetic.main.fragment_car_list.*

class CarListFragment : Fragment() {

    private lateinit var carListBinding: FragmentCarListBinding
    private lateinit var mViewModel : CarListViewModel
    private lateinit var mListener : CarListListener
    private val mAdapter = CarListAdapter()

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
        rv_cars_list.layoutManager = LinearLayoutManager(context)
        rv_cars_list.adapter = mAdapter
    }

    private fun bindInfos(){
        carListBinding.tbCarList.title = mViewModel.toolBarTitle
        tv_car_quantity.text = mViewModel.getCarQuantityText()
    }

    private fun setupListener(){
        mListener = object : CarListListener{
        }
    }

}