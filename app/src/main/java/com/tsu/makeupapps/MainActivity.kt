package com.tsu.makeupapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tsu.makeupapps.network.Controller

class MainActivity : AppCompatActivity() {
    private val cotroller = Controller()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cotroller.getByBrand(brand = "Dior", onSuccess = {
            Toast.makeText(this@MainActivity, "Не ошибка чата", Toast.LENGTH_LONG).show()
        },
            onFailure = {
                Toast.makeText(this@MainActivity, "Ошибка чата", Toast.LENGTH_LONG).show()
            })
    }
}