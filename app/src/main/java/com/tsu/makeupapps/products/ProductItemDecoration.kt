package com.tsu.makeupapps.products

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tsu.makeupapps.R

class ProductItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return


        val margin8 = parent.context.resources.getDimensionPixelSize(R.dimen.margin8)
        val margin16 = parent.context.resources.getDimensionPixelSize(R.dimen.margin16)
        val margin24 = parent.context.resources.getDimensionPixelSize(R.dimen.margin24)
        val margin12 = parent.context.resources.getDimensionPixelSize(R.dimen.margin12)
        val margin80 = parent.context.resources.getDimensionPixelSize(R.dimen.margin80)

        val newRect = when (position) {
            0 -> Rect(margin16, margin24, margin8, margin12)
            1 -> Rect(margin8, margin24, margin16, margin12)
            state.itemCount-2-> Rect(margin16, margin12, margin8, margin80)
            state.itemCount-1-> Rect(margin8, margin12, margin16, margin80)

            else -> {
                if (position % 2 == 0) {
                    Rect(margin16, margin12, margin8, margin12)
                } else {
                        Rect(margin8, margin12, margin16, margin12)
                    }
                }


            }

        outRect.apply{
            left = newRect.left
            right = newRect.right
            top = newRect.top
            bottom = newRect.bottom
        }
    }
}