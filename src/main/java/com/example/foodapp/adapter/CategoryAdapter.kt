package com.example.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.model.Category


class CategoryAdapter() : RecyclerView.Adapter<CategoryAdapter.CategotyViewHolder>() {

    var category = ArrayList<Category>()
    var listener: AdapterView.OnItemClickListener? = null

   public fun setData (category: List<Category>) {
        this.category = category as ArrayList<Category>

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategotyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent, false)

        return CategotyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategotyViewHolder, position: Int) {

        val currentCategory = category[position]

        holder.txtName.findViewById<TextView>(R.id.title1).text = category[position].title
        holder.img.setImageResource(currentCategory.pic)

        holder.itemView.setBackgroundResource(R.drawable.cat_background)
        holder.itemView.setBackgroundResource(R.drawable.cat_backgound1)
        holder.itemView.setBackgroundResource(R.drawable.cat_background2)
        holder.itemView.setBackgroundResource(R.drawable.cat_background3)

    }

    class CategotyViewHolder (view : View) : RecyclerView.ViewHolder(view){

        internal val txtName = itemView.findViewById<TextView>(R.id.title1)
        internal val img = itemView.findViewById<ImageView>(R.id.picture)

    }
}





