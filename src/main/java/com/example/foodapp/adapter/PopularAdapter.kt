package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.Food

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

   lateinit var adapter: PopularAdapter
    lateinit var layoutManager : LinearLayoutManager

    var arrPopular = ArrayList<Food>()
    var listener: AdapterView.OnItemClickListener? = null

    class PopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setData(food: List<Food>) {
        arrPopular = food as ArrayList<Food>

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        return PopularAdapter.PopularViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.popular_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrPopular.size

    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.title_name).text = arrPopular[position].title
        holder.itemView.findViewById<TextView>(R.id.amount).text = arrPopular[position].amount
        holder.itemView.context.resources.getIdentifier(String(), "drawable", holder.itemView.context.packageName)
    }
}