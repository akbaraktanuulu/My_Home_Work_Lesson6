package com.example.my_home_work_lesson6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.my_home_work_lesson6.databinding.ItemFoodHolderBinding
import java.util.LinkedList

class FoodAdaptor(private val foods: LinkedList<Food>) : RecyclerView.Adapter<FoodAdaptor.FoodViewHolder>() {

    // Создание ViewHolder'а
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodViewHolder(binding)
    }

    // Привязка данных к ViewHolder'у
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foods[position])
    }

    // Возвращает количество элементов в списке
    override fun getItemCount(): Int {
        return foods.size
    }

    // ViewHolder для отображения элемента списка
    class FoodViewHolder(private val binding: ItemFoodHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Метод для привязки данных к элементам интерфейса
        fun bind(food: Food) {
            binding.tvName.text = food.name
            Glide.with(itemView.context)
                .load(food.avatar)
                .into(binding.imageView)
        }
    }
}