package com.example.foodapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.adapter.CategoryAdapter
import com.example.foodapp.adapter.PopularAdapter
import com.example.foodapp.model.Category
import com.example.foodapp.model.Food

class MainActivity : AppCompatActivity() {

    var category = ArrayList<Category>()
    var categoryAdapter = CategoryAdapter()

    var food = ArrayList<Food>()
    var popularAdapter = PopularAdapter()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        category.add(Category(R.drawable.cat_1, "Pizza"))
        category.add(Category(R.drawable.cat_2, "Burger"))
        category.add(Category(R.drawable.cat_3, "Bagel"))
        category.add(Category(R.drawable.soda, "Drinks"))

        categoryAdapter.setData(category)

        food.add(Food(R.drawable.pizza, "Pizza", "Ksh.2500.00"))
        food.add(Food(R.drawable.hamburger, "Hamburger", "Ksh.1800.00"))
        food.add(Food(R.drawable.bagel, "Bagel", "Ksh.1750.00"))
        food.add(Food(R.drawable.drinks, "Drinks", "Ksh.70.00"))

        popularAdapter.setData(food)

      recyclerView = findViewById(R.id.recyclerView)
       val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = categoryAdapter

        popularAdapter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.adapter = popularAdapter



    }

}

