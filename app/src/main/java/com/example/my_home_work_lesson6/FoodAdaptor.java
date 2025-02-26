package com.example.my_home_work_lesson6;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_home_work_lesson6.databinding.ItemFoodHolderBinding;

public class FoodAdaptor extends RecyclerView.Adapter<FoodAdaptor.FoodViweHolder> {
    @NonNull
    @Override
    public FoodViweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViweHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class FoodViweHolder extends RecyclerView.ViewHolder {
        private ItemFoodHolderBinding binding;


        public FoodViweHolder(ItemFoodHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
