package com.example.foodapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ShowDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)

        val title : TextView = findViewById(R.id.titleTxt)
        val image : ImageView = findViewById(R.id.food_pic)
        val text : TextView = findViewById(R.id.descriptionTxt)
        val txt : TextView = findViewById(R.id.txtPrice)
        val plusBtn : ImageView = findViewById(R.id.plus)
        val minusBtn : ImageView = findViewById(R.id.minus)
        var noOfOrder : TextView = findViewById(R.id.noOfOrder)

        val bundle : Bundle? = intent.extras
        val titleTxt = bundle!!.getString("title")
        val imageView = bundle.getInt("pic")
        val descriptionTxt = bundle.getString("description")
        val amount = bundle.getString("amount")

        title.text = titleTxt
        text.text = descriptionTxt
        txt.text =amount
        image.setImageResource(imageView)
        noOfOrder.text


var num = 0
        plusBtn.setOnClickListener (View.OnClickListener {
            num ++
            noOfOrder = noOfOrder
            noOfOrder.text = (num +1).toString()

        })

        minusBtn.setOnClickListener(View.OnClickListener {
            num --
            if (num>0)
                noOfOrder = noOfOrder
            noOfOrder.text = (num -1).toString()

        })

        val addToCartBtn  = findViewById<TextView>(R.id.cart_btn)
        addToCartBtn.setOnClickListener {
            Toast.makeText(this, "Item added to Cart", Toast.LENGTH_LONG).show()

        }
}

}

