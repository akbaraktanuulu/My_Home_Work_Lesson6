package com.example.my_home_work_lesson6;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.ViewHolder> {
    private final List<Item2> itemList;
    private final OnItemClickListener onItemClickListener;

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Constructor
    public ItemAdapter2(List<Item2> itemList, OnItemClickListener onItemClickListener) {
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item2 item = itemList.get(position);
        holder.burgerImage.setImageResource(item.getImageResId());
        holder.burgerName.setText(item.getTitle());
        holder.burgerPrice.setText(item.getPrice());

        // Change the background color of the CardView for the first item
        if (position == 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FF0000"));
            holder.burgerName.setTextColor(Color.WHITE);
            holder.burgerPrice.setTextColor(Color.WHITE);
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.burgerName.setTextColor(Color.GRAY);
            holder.burgerPrice.setTextColor(Color.GRAY);
        }

        ViewGroup.LayoutParams layoutParams = holder.cardView.getLayoutParams();

        if (position == 0) {
            layoutParams.height = (int) holder.itemView.getContext().getResources().getDimension(R.dimen.selected_card_height); // Set the height to a larger value (e.g., 300dp)
        } else {
            layoutParams.height = (int) holder.itemView.getContext().getResources().getDimension(R.dimen.default_card_height); // Set back to default height (220dp)
        }
        holder.cardView.setLayoutParams(layoutParams);

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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView burgerImage;
        TextView burgerName;
        TextView burgerPrice;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            burgerImage = itemView.findViewById(R.id.burgerImage);
            burgerName = itemView.findViewById(R.id.burgerName);
            burgerPrice = itemView.findViewById(R.id.burgerPrice);
            cardView = itemView.findViewById(R.id.burgerCard2);
        }
    }
}
