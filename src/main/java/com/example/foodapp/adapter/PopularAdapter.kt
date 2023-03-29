package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.Food

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

   lateinit var adapter: PopularAdapter
    lateinit var layoutManager : LinearLayoutManager

    var popular = ArrayList<Food>()
    var listener: AdapterView.OnItemClickListener? = null

    fun setData(food: List<Food>) {
        popular = food as ArrayList<Food>

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
        return popular.size

    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {

        val currentPopular = popular[position]

        holder.titleName.findViewById<TextView>(R.id.title_name).text = popular[position].title
        holder.txtAmount.findViewById<TextView>(R.id.amount).text = popular[position].amount
        holder.img.setImageResource(currentPopular.pic)
    }

    class PopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleName = itemView.findViewById<TextView>(R.id.title_name)
        val txtPrice = itemView.findViewById<TextView>(R.id.price)
        val txtAmount = itemView.findViewById<TextView>(R.id.amount)
        val txtAdd = itemView.findViewById<TextView>(R.id.add)
        val img = itemView.findViewById<ImageView>(R.id.popular_list)

    }
}