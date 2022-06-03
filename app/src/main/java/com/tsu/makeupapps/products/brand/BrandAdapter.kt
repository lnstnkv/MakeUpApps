package com.tsu.makeupapps.products.brand

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tsu.makeupapps.Brands
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.ItemBrandBinding

class BrandAdapter (
    private val listener: BrandAdapterListener
) : ListAdapter<Brands, BrandAdapter.ViewHolder>(DIFF) {

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<Brands>() {
            override fun areItemsTheSame(oldItem: Brands, newItem: Brands) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Brands, newItem: Brands) =
                oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.item_brand, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemBrandBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                listener.onItemClick(getItem(bindingAdapterPosition))
            }
        }

        fun bind(brands: Brands) = with(binding) {
            textViewNameBrand.text = brands.name

                Glide
                    .with(imageViewLogoBrand.context)
                    .load(brands.image)
                    .into(imageViewLogoBrand)

        }
    }

    interface BrandAdapterListener {
        fun onItemClick(item: Brands)
    }

}