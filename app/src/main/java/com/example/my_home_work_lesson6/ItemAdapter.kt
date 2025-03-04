package com.example.my_home_work_lesson6

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter // Constructor
    (private var itemList: List<Item>, private val onItemClickListener: OnItemClickListener?) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // Interface for item click listener
    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.burgerText.setText(item.title)
        holder.burgerIcon.setImageResource(item.imageResId)

        if (position == 0) {
            holder.burgerIcon.setColorFilter(
                Color.parseColor("#FF0000"),
                PorterDuff.Mode.SRC_IN
            ) // Red tint for the first item
        } else {
            holder.burgerIcon.colorFilter = null
        }
        holder.itemView.setOnClickListener { v: View? ->
            onItemClickListener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var burgerIcon: ImageView = itemView.findViewById(R.id.burgerIcon)
        var burgerText: TextView = itemView.findViewById(R.id.burgerText)
    }

    fun updateList(newList: List<Item>) {
        this.itemList = newList
        notifyDataSetChanged() // Refresh RecyclerView
    }
}
