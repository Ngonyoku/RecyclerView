package com.example.recyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ItemsList> itemsListArrayList;
    private ItemAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsListArrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            itemsListArrayList.add(new ItemsList("Position " + i, "BlablaBla"));
        }

        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ItemAdapter(itemsListArrayList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "Card View Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImageClick(int position) {
                Toast.makeText(MainActivity.this, "Profile Picture Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("DELETE ITEM")
                        .setMessage("Are You Sure You want to delete Position" + position)
                        .setPositiveButton("Yes, I'm Sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                removeItem(position);
                            }
                        }).show();
            }
        });
    }

    public void addItem(int position) {
        itemsListArrayList.add(position, new ItemsList("Added at " + position, "I'm New"));
        adapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        itemsListArrayList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
