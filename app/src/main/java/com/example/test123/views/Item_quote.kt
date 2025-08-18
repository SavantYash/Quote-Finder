package com.example.test123.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test123.R

class Item_quote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_quote)

        val filter = intent.getStringExtra("FILTER") ?: "ALL"

        val fragment = QuoteFragment.newInstance(filter)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}