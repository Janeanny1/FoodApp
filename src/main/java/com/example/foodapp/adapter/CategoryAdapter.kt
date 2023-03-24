package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.Category


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategotyViewHolder>() {

    lateinit var adapter : CategoryAdapter
    lateinit var layoutManager: LinearLayoutManager

    var arrCategory = ArrayList<Category>()
    var listener: AdapterView.OnItemClickListener? = null

    class CategotyViewHolder (view : View) : RecyclerView.ViewHolder(view){

    }

    fun setData (category: List<Category>) {
        arrCategory = category as ArrayList<Category>

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategotyViewHolder {
        return CategoryAdapter.CategotyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrCategory.size
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategotyViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.title1).text = arrCategory[position].title

        holder.itemView.setBackgroundResource(R.drawable.cat_background)
        holder.itemView.setBackgroundResource(R.drawable.cat_backgound1)
        holder.itemView.setBackgroundResource(R.drawable.cat_background2)
        holder.itemView.setBackgroundResource(R.drawable.cat_background3)

    }
}





