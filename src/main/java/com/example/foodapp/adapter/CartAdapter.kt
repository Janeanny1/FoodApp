package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.Food

class CartAdapter : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private lateinit var food : ArrayList<Food>
    private lateinit var lListener : PopularAdapter.onItemClickListener
    var cart : ArrayList<Food> = ArrayList<Food>()

    fun setOnItemClickListener (listener : PopularAdapter.onItemClickListener){
        lListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.cart_list, parent, false)
        return ViewHolder(inflater, lListener)
    }

    override fun getItemCount(): Int {
        return cart.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val numOfCart = food[position]
        val currentItem = food[position]

        holder.cartTitle.text = food[position].title
        holder.feeItem.text =  "amount Ksh" + String.format("amount", food[position].amount * food[position].numOfCart)
        holder.totalItem.text = "amount Ksh" + String.format("%.2", food[position].amount * food[position].numOfCart)
        holder.num.text = food [position].numOfCart
        holder.cartPic.setImageResource(currentItem.pic)

        var count = holder.num.text.toString().toInt()
        holder.imgMinus.setOnClickListener(View.OnClickListener {
            count --
            if (count >0)
            holder.num.text = (count -1).toString()

        })

        holder.imgPlus.setOnClickListener(View.OnClickListener {
            count ++
            if (count<0)
            holder.num.text = (count +1).toString()

        })

    }

  inner  class ViewHolder(itemView: View, listener : PopularAdapter.onItemClickListener) : RecyclerView.ViewHolder(itemView) {

      val cartTitle = itemView.findViewById<TextView>(R.id.cartTitle)
      val feeItem = itemView.findViewById<TextView>(R.id.feeItem)
      val totalItem = itemView.findViewById<TextView>(R.id.totalItem)
      val num = itemView.findViewById<TextView>(R.id.num)
      val imgMinus = itemView.findViewById<ImageView>(R.id.minusCartBtn)
      val imgPlus = itemView.findViewById<ImageView>(R.id.plusCartBtn)
      val cartPic = itemView.findViewById<ImageView>(R.id.cartPic)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

}

private operator fun String.times(numOfCart: String): Any? {
    return numOfCart

}



