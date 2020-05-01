package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<ItemsList> itemsLists;

    public ItemAdapter(ArrayList<ItemsList> lists) {
        this.itemsLists = lists;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView name, text;

        public ItemViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            text = itemView.findViewById(R.id.text);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemsList items = itemsLists.get(position);
        holder.name.setText(items.getName());
        holder.text.setText(items.getText());
    }

    @Override
    public int getItemCount() {
        return itemsLists.size();
    }

}
