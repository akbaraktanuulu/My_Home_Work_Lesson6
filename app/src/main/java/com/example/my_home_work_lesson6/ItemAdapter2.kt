package com.example.my_home_work_lesson6

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter2 // Constructor
    (private val itemList: List<Item2>, private val onItemClickListener: OnItemClickListener?) :
    RecyclerView.Adapter<ItemAdapter2.ViewHolder>() {
    // Interface for item click listener
    fun interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.burgerImage.setImageResource(item.imageResId)
        holder.burgerName.setText(item.title)
        holder.burgerPrice.setText(item.price)

        // Change the background color of the CardView for the first item
        if (position == 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FF0000"))
            holder.burgerName.setTextColor(Color.WHITE)
            holder.burgerPrice.setTextColor(Color.WHITE)
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            holder.burgerName.setTextColor(Color.GRAY)
            holder.burgerPrice.setTextColor(Color.GRAY)
        }

        val layoutParams = holder.cardView.layoutParams

        if (position == 0) {
            layoutParams.height =
                holder.itemView.context.resources.getDimension(R.dimen.selected_card_height)
                    .toInt() // Set the height to a larger value (e.g., 300dp)
        } else {
            layoutParams.height =
                holder.itemView.context.resources.getDimension(R.dimen.default_card_height)
                    .toInt() // Set back to default height (220dp)
        }
        holder.cardView.layoutParams = layoutParams

        holder.itemView.setOnClickListener { v: View? ->
            onItemClickListener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var burgerImage: ImageView = itemView.findViewById(R.id.burgerImage)
        var burgerName: TextView = itemView.findViewById(R.id.burgerName)
        var burgerPrice: TextView = itemView.findViewById(R.id.burgerPrice)
        var cardView: CardView = itemView.findViewById(R.id.burgerCard2)
    }
}