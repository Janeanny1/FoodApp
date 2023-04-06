package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.adapter.CartAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView3: RecyclerView
    private lateinit var itemTotal : TextView
    private lateinit var delivery : TextView
    private lateinit var taxTxt : TextView
    private lateinit var total : TextView
    private lateinit var taxFee : TextView
    private lateinit var totalFee : TextView
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView3 = findViewById(R.id.recyclerView3)
        itemTotal = findViewById(R.id.itemTotal)
        delivery = findViewById(R.id.delivery)
        taxFee = findViewById(R.id.taxFee)
        taxTxt = findViewById(R.id.taxTxt)
        total = findViewById(R.id.total)
        totalFee = findViewById(R.id.totalFee)

        recyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView3.setHasFixedSize(true)
        recyclerView3.adapter = CartAdapter()


        val floatingActionButton = findViewById<FloatingActionButton>(R.id.cartBtn)
        val homeBtn = findViewById<LinearLayout>(R.id.home_btn)
        val check = findViewById<TextView>(R.id.check_out)
        floatingActionButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java )
            startActivity(intent)
        }

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        check.setOnClickListener {
            intent = Intent(this, IntroActivity::class.java)
            Toast.makeText(this, "Your Successful Checked Out", Toast.LENGTH_LONG).show()
            startActivity(intent)

        }

    }

}



