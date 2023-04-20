package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.adapter.CartAdapter
import com.example.foodapp.adapter.CategoryAdapter
import com.example.foodapp.adapter.PopularAdapter
import com.example.foodapp.model.Category
import com.example.foodapp.model.Food
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var category = ArrayList<Category>()
    var categoryAdapter = CategoryAdapter()


    var food = ArrayList<Food>()
    var popularAdapter = PopularAdapter()
    var cartAdapter = CartAdapter()

    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        category.add(Category(R.drawable.cat_1, "Pizza"))
        category.add(Category(R.drawable.cat_2, "Burger"))
        category.add(Category(R.drawable.cat_3, "Bagel"))
        category.add(Category(R.drawable.soda, "Drinks"))

        categoryAdapter.setData(category)

        food.add(Food(R.drawable.pizza, "Pizza", "2000.00", "1","Onion, Cheese, tomato-sauce,tomato, meat, spices, fresh oregano "))
        food.add(Food(R.drawable.hamburger, "Hamburger", "1000.00", "1","special sauce, raw onion,mayonnaise, bun, lettuce "))
        food.add(Food(R.drawable.bagel, "Bagel", "1450.00", "1", "raw onion, cream cheese,lettuce "))
        food.add(Food(R.drawable.drinks, "Drinks", "70.00", "1","carbonated water, sugar, caramel color,caffeine, phosphoric acid,citric acid,natural flavors,carbon dioxide"))

        popularAdapter.setData(food)

        recyclerView1 = findViewById(R.id.recyclerView)
        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.setHasFixedSize(true)
        recyclerView1.adapter = categoryAdapter

        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.adapter = popularAdapter


        popularAdapter.setOnItemClickListener(object : PopularAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent (this@MainActivity, ShowDetailsActivity::class.java)
                intent.putExtra("title", food[position].title)
                intent.putExtra("description", food[position].description)
                intent.putExtra("amount", food[position].amount)
                intent.putExtra("pic", food[position].pic)
                startActivity(intent)
            }

        })

        cartAdapter.setOnItemClickListener(object : PopularAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent (this@MainActivity, CartActivity::class.java)
                intent.putExtra("title", food[position].title)
                intent.putExtra("amount", food[position].amount)
                intent.putExtra("numOfCart", food[position].numOfCart)
                intent.putExtra("pic", food[position].pic)
                startActivity(intent)
            }

        })


        val floatingActionButton = findViewById<FloatingActionButton>(R.id.cartBtn)
        val homeBtn = findViewById<LinearLayout>(R.id.home_btn)
        floatingActionButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java )
            startActivity(intent)
        }

        homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


}











