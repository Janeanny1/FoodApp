package com.example.foodapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowDetailsActivity : AppCompatActivity() {

    private lateinit var addToCartBtn : Button
    private lateinit var titleTxt : TextView
    private lateinit var txtPrice : TextView
    private lateinit var description : TextView
    private lateinit var noOfOrder : TextView
    private lateinit var minus : ImageView
    private lateinit var plus : ImageView

    var num =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)

        addToCartBtn  = findViewById(R.id.add_to_cart_btn)
        titleTxt = findViewById(R.id.titleTxt)
        txtPrice = findViewById(R.id.txtPrice)
        description = findViewById(R.id.descriptionTxt)
        noOfOrder = findViewById(R.id.noOfOrder)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.plus)

        minus.setOnClickListener {
            num++

        }

        plus.setOnClickListener {
            num--
        }

        addToCartBtn.setOnClickListener {

        }
}

    }
