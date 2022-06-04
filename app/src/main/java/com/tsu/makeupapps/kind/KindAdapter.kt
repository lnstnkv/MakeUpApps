package com.tsu.makeupapps.kind

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tsu.makeupapps.Brands
import com.tsu.makeupapps.KindProduct
import com.tsu.makeupapps.R
import com.tsu.makeupapps.databinding.ItemBrandBinding
import com.tsu.makeupapps.databinding.ItemKindBinding
import com.tsu.makeupapps.products.brand.BrandAdapter

class KindAdapter (
    private val listener: KindAdapterListener
) : ListAdapter<KindProduct, KindAdapter.ViewHolder>(DIFF) {

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<KindProduct>() {
            override fun areItemsTheSame(oldItem: KindProduct, newItem: KindProduct) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: KindProduct, newItem: KindProduct) =
                oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context).inflate(R.layout.item_kind, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemKindBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                listener.onItemClick(getItem(bindingAdapterPosition))
            }
        }

        fun bind(product: KindProduct) = with(binding) {
            textViewNameProductKind.text = product.name
            textViewNameBrandKind.text = product.brand
            Glide
                .with(imageViewLogoProductKind.context)
                .load(product.image)
                .circleCrop()
                .into(imageViewLogoProductKind)

        }
    }

    interface KindAdapterListener {
        fun onItemClick(item: KindProduct)
    }

}