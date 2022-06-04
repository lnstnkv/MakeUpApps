package com.tsu.makeupapps.products.brand

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tsu.makeupapps.Brands
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.FragmentBrandBinding
import com.tsu.makeupapps.kind.KindProductsActivity
import com.tsu.makeupapps.registration.RegisterActivity

class BrandFragment: Fragment(R.layout.fragment_brand) {
    companion object {
        val TAG = BrandFragment::class.java.simpleName
        fun newInstance() = BrandFragment()
    }
    private val peopleAdapterListener = object : BrandAdapter.BrandAdapterListener {
        override fun onItemClick(item: Brands) {
            val intent = Intent(activity, KindProductsActivity::class.java)
            intent.putExtra("fname", item.name)
            startActivity(intent)
        }
    }
    private val brandAdapter = BrandAdapter(peopleAdapterListener)
    private lateinit var viewbinding: FragmentBrandBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewbinding = FragmentBrandBinding.bind(view)
        initRecyclerView()
    }
    private fun initRecyclerView() = with(viewbinding){


        brandsRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        brandsRecycler.apply {
            adapter = brandAdapter
            addItemDecoration(BrandItemDecoration())
        }

        val brandItems = mutableListOf<Brands>()
        brandItems.add(Brands("1", "Nyx", R.drawable.nyx))
        brandItems.add(Brands("2", "Dior", R.drawable.dior1))
        brandItems.add(Brands("3", "Clinique", R.drawable.clinique))
        brandItems.add(Brands("4", "Loreal", R.drawable.loreal))
        brandItems.add(Brands("5", "Covergirl", R.drawable.covergirl))
        brandItems.add(Brands("6", "Pure Anada", R.drawable.pureanada))
        brandAdapter.submitList(brandItems)
    }
}