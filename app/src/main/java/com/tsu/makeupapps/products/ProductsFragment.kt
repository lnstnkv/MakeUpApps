package com.tsu.makeupapps.products

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.FragmentProductsBinding

class ProductsFragment:Fragment(R.layout.fragment_products){
    companion object {
        val TAG = ProductsFragment::class.java.simpleName
        fun newInstance() = ProductsFragment()
    }
    private lateinit var viewbinding: FragmentProductsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewbinding = FragmentProductsBinding.bind(view)
        initRecyclerView()
    }
    private val productAdapterListener = object : ProductAdapter.ProductAdapterListener {
        override fun onItemClick(item: Product) {
            print(item)
        }
    }
    private val productAdapter = ProductAdapter(productAdapterListener)

    private fun initRecyclerView() = with(viewbinding){


        productRecycler.layoutManager =
           // LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        productRecycler.apply {
            adapter = productAdapter
           // addItemDecoration(ProductItemDecoration())
        }

        val productItems = mutableListOf<Product>()
        productItems.add(Product("1", "Blush", R.drawable.blush))
        productItems.add(Product("2", "Bronzer", R.drawable.bronzer))
        productItems.add(Product("3", "Eyebrow", R.drawable.eyebrow))
        productItems.add(Product("4", "Eyeliner", R.drawable.eyeliner))
        productItems.add(Product("5", "Eyeshadow", R.drawable.eyeshadow))
        productItems.add(Product("6", "Foundation", R.drawable.foundation))
        productItems.add(Product("7", "Lip Liner", R.drawable.lipliner))
        productItems.add(Product("8", "Lipstick", R.drawable.liostick))
        productAdapter.submitList(productItems)
    }

}