package com.tsu.makeupapps.products

import androidx.fragment.app.Fragment
import com.tsu.makeupapps.R
import com.tsu.makeupapps.settings.SettingsFragment

class ProductsFragment:Fragment(R.layout.activity_products){
    companion object {
        val TAG = ProductsFragment::class.java.simpleName
        fun newInstance() = ProductsFragment()
    }
}