package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        for (int i = 0; i < 100; i++) {
            itemsListArrayList.add(new ItemsList("Position " + i, "BlablaBla"));
        }

        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ItemAdapter(itemsListArrayList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
