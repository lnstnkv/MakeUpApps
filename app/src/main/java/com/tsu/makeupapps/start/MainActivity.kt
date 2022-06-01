package com.tsu.makeupapps.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tsu.makeupapps.databinding.ActivityMainBinding
import com.tsu.makeupapps.registration.RegisterActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent(this@MainActivity, RegisterActivity::class.java)
        binding.buttonUp.setOnClickListener {
            startActivity(intent)
        }
    }
}