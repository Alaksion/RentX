package com.example.rentx.home.presentation.appointments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rentx.R
import com.example.rentx.databinding.FragmentAppointmentsBinding

class AppointmentsFragment : Fragment() {

    private lateinit var mVm: AppointmentsViewModel
    private lateinit var fragmentBinding: FragmentAppointmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mVm = ViewModelProvider(this).get(AppointmentsViewModel::class.java)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_appointments, container, false)

        setToolbarValues()

        return fragmentBinding.root
    }


    private fun setToolbarValues() {
        val appointmentsQuantityText = "${mVm.appointmentsQtd} agendamentos"
        fragmentBinding.tbAppointments.title = mVm.toolbarTitle
        fragmentBinding.tvAppointmentsQuantity.text = appointmentsQuantityText
    }

}