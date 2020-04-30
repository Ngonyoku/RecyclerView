package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ItemsList> itemsListArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsListArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemsListArrayList.add(new ItemsList("My Name", "BlablaBla"));
        }
        recyclerView = findViewById(R.id.recycler);
    }
}
