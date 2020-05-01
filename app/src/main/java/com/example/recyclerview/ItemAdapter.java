package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<ItemsList> itemsLists;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onImageClick(int position);

        void onDeleteClick(int position);
    }

    public ItemAdapter(ArrayList<ItemsList> lists) {
        this.itemsLists = lists;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView name, text;
        public CircleImageView imageView;
        public ImageView deleteIcon;

        public ItemViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            text = itemView.findViewById(R.id.text);
            deleteIcon = itemView.findViewById(R.id.delete_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onImageClick(position);
                        }
                    }
                }
            });

            deleteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(view, itemClickListener);
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
