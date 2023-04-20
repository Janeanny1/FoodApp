package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.Food

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener (listener : onItemClickListener){
        mListener = listener
    }


    var popular = ArrayList<Food>()

    fun setData(food: List<Food>) {
        popular = food as ArrayList<Food>

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.PopularViewHolder {

         val itemView = LayoutInflater.from(parent.context).inflate(R.layout.popular_list,
             parent, false)
        return PopularViewHolder(itemView, mListener)

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

    class PopularViewHolder(view: View, listener : onItemClickListener) : RecyclerView.ViewHolder(view) {
        val titleName = itemView.findViewById<TextView>(R.id.title_name)
        val txtPrice = itemView.findViewById<TextView>(R.id.price)
        val txtAmount = itemView.findViewById<TextView>(R.id.amount)
        val txtAdd = itemView.findViewById<TextView>(R.id.add)
        val img = itemView.findViewById<ImageView>(R.id.popular_list)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

}