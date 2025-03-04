package com.example.my_home_work_lesson6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.my_home_work_lesson6.databinding.ItemFoodHolderBinding;

import java.util.LinkedList;

public class FoodAdaptor extends RecyclerView.Adapter<FoodAdaptor.FoodViweHolder> {

    private LinkedList<Food> foods;
    public FoodAdaptor(LinkedList<Food> foods){
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFoodHolderBinding binding = ItemFoodHolderBinding.
                inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FoodViweHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViweHolder holder, int position) {
        holder.bind(foods.get(position));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }


    public static class FoodViweHolder extends RecyclerView.ViewHolder {
        private ItemFoodHolderBinding binding;


        public FoodViweHolder(ItemFoodHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(Food food) {
           binding.tvName.setText(food.getName());
            Glide.with(super.itemView.getContext()).load(food.getAvatar()).into(binding.imageView);
        }
    }
}
