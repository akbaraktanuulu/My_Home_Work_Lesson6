package com.example.my_home_work_lesson6;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private OnItemClickListener onItemClickListener;

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Constructor
    public ItemAdapter(List<Item> itemList, OnItemClickListener onItemClickListener) {
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.burgerText.setText(item.getTitle());
        holder.burgerIcon.setImageResource(item.getImageResId());

        if (position == 0) {
            holder.burgerIcon.setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.SRC_IN); // Red tint for the first item
        } else {
            holder.burgerIcon.setColorFilter(null);
        }
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView burgerIcon;
        TextView burgerText;

        public ItemViewHolder(View itemView) {
            super(itemView);
            burgerIcon = itemView.findViewById(R.id.burgerIcon);
            burgerText = itemView.findViewById(R.id.burgerText);
        }
    }

    public void updateList(List<Item> newList) {
        this.itemList = newList;
        notifyDataSetChanged(); // Refresh RecyclerView
    }
}

