
package com.tsu.makeupapps.kind

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.tsu.makeupapps.CurrentProductActivity
import com.tsu.makeupapps.KindProduct
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.ActivityKindProductsBinding
import com.tsu.makeupapps.registration.RegisterActivity

class KindProductsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityKindProductsBinding.inflate(layoutInflater) }

    private val kindAdapterListener = object : KindAdapter.KindAdapterListener {
        override fun onItemClick(item: KindProduct) {
            val intent = Intent(this@KindProductsActivity, CurrentProductActivity::class.java)
            startActivity(intent)
        }
    }
    private val kindAdapter = KindAdapter(kindAdapterListener)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val fName = intent.getStringExtra("fname")
        binding.TextName.text=fName
        initRecyclerView()
    }
    private fun initRecyclerView() = with(binding){


        kindRecycler.layoutManager =
            GridLayoutManager(this@KindProductsActivity,2)
        kindRecycler.apply {
            adapter = kindAdapter
            addItemDecoration(KindItemDecoration())
        }

        val kindProductItems = mutableListOf<KindProduct>()
        for (i in 1..10){
            kindProductItems.add(KindProduct(i.toString(), "Nyx","Nyx", R.drawable.nyx))
        }
        kindAdapter.submitList(kindProductItems)
    }
}