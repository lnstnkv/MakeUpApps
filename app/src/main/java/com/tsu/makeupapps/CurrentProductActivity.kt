package com.tsu.makeupapps

import android.R
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tsu.makeupapps.databinding.ActivityCurentProductBinding


class CurrentProductActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCurentProductBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
