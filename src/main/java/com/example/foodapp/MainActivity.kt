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

    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        category.add(Category(R.drawable.cat_1, "Pizza"))
        category.add(Category(R.drawable.cat_2, "Burger"))
        category.add(Category(R.drawable.cat_3, "Bagel"))
        category.add(Category(R.drawable.soda, "Drinks"))

        categoryAdapter.setData(category)

        food.add(Food(R.drawable.pizza, "Pizza", "2500.00", "Onion, Cheese, tomato-sauce,tomato, meat, spices, fresh oregano "))
        food.add(Food(R.drawable.hamburger, "Hamburger", "1800.00", "special sauce, raw onion,mayonnaise, bun, lettuce "))
        food.add(Food(R.drawable.bagel, "Bagel", "1750.00", "raw onion, cream cheese,lettuce "))
        food.add(Food(R.drawable.drinks, "Drinks", "70.00", "carbonated water, sugar, caramel color, caffeine, phosphoric acid, citric acid, natural flavors, carbon dioxide"))

        popularAdapter.setData(food)

        recyclerView1 = findViewById(R.id.recyclerView)
        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.setHasFixedSize(true)
        recyclerView1.adapter = categoryAdapter

        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.adapter = popularAdapter
    }
}



