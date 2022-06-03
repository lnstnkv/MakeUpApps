package com.tsu.makeupapps.products

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.ActivityProductsBinding
import com.tsu.makeupapps.products.brand.BrandFragment
import com.tsu.makeupapps.settings.SettingsFragment

class ProductsActivity : AppCompatActivity() {
    private val viewbinding by lazy { ActivityProductsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewbinding.root)
        if(savedInstanceState==null){
            selectScreen(ProductsFragment.TAG, ProductsFragment.newInstance())
        }
        viewbinding.bottomNavigation.setOnItemSelectedListener {
            revealFragment(it.itemId)

        }
    }
    private fun revealFragment(itemId :Int):Boolean{

        when(itemId){

            R.id.navigation_settings -> {
                selectScreen(SettingsFragment.TAG, SettingsFragment.newInstance())
                return true
            }
            R.id.navigation_products -> {
                selectScreen(ProductsFragment.TAG, ProductsFragment.newInstance())
                return true
            }
            R.id.navigation_brand -> {
                selectScreen(BrandFragment.TAG, BrandFragment.newInstance())
                return true
            }
            else -> return false
        }

    }
    private fun selectScreen(tag:String, fragment: Fragment){
        supportFragmentManager.commit {
            val active= findActiveFragment()
            val target = supportFragmentManager.findFragmentByTag(tag)

            if(active != null && target != null && active== target) return@commit

            if (active!= null){
                hide(active)
            }
            if (target == null){
                add (R.id.fragmentContainerView, fragment, tag)
            } else {
                show(target)
            }
        }
    }
    private  fun findActiveFragment()= supportFragmentManager.fragments.find { it.isVisible }
}