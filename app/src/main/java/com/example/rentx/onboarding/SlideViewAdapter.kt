package com.example.rentx.onboarding
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class SlideViewAdapter(val context: Context) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return 2
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

    }
}