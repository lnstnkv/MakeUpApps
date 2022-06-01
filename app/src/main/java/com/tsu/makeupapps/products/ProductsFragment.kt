package com.tsu.makeupapps.products

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.FragmentProductsBinding
import com.tsu.makeupapps.databinding.FragmentSettngsBinding
import com.tsu.makeupapps.settings.SettingsFragment

class ProductsFragment:Fragment(R.layout.activity_products){
    companion object {
        val TAG = ProductsFragment::class.java.simpleName
        fun newInstance() = ProductsFragment()
    }
    private lateinit var viewbinding: FragmentProductsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewbinding = FragmentProductsBinding.bind(view)
    }

}