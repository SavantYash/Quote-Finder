package com.example.test123.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.test123.R
import com.example.test123.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAll).setOnClickListener {
            openQuotes("ALL")
        }
        findViewById<Button>(R.id.btnStar).setOnClickListener {
            openQuotes("STAR")
        }
        findViewById<Button>(R.id.btnHeart).setOnClickListener {
            openQuotes("HEART")
        }
        findViewById<Button>(R.id.btnBoth).setOnClickListener {
            openQuotes("BOTH")
        }
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
            viewModel.getNewQuotes()
        }
    }

    private fun openQuotes(filter: String) {
        val intent = Intent(this, Item_quote::class.java)
        intent.putExtra("FILTER", filter)
        startActivity(intent)
    }


}