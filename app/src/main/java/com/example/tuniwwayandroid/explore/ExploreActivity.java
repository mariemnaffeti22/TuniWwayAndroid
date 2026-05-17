package com.example.tuniwwayandroid.explore;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuniwwayandroid.R;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {

    RecyclerView recyclerCategories;
    AutoCompleteTextView searchDestination;

    ArrayList<String> categories;
    ArrayList<Integer> icons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        recyclerCategories = findViewById(R.id.recyclerCategories);
        searchDestination = findViewById(R.id.searchDestination);

        categories = new ArrayList<>();
        categories.add("Plages");
        categories.add("Hôtels");
        categories.add("Désert");
        categories.add("Médinas");
        categories.add("Musées");
        categories.add("Restaurants");

        icons = new ArrayList<>();
        icons.add(android.R.drawable.ic_menu_gallery);
        icons.add(android.R.drawable.ic_menu_myplaces);
        icons.add(android.R.drawable.ic_menu_compass);
        icons.add(android.R.drawable.ic_menu_mapmode);
        icons.add(android.R.drawable.ic_menu_info_details);
        icons.add(android.R.drawable.ic_menu_manage);

        CategoryAdapter adapter = new CategoryAdapter(this, categories, icons);

        recyclerCategories.setLayoutManager(new LinearLayoutManager(this));
        recyclerCategories.setAdapter(adapter);

        ArrayAdapter<String> searchAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                categories
        );

        searchDestination.setAdapter(searchAdapter);
    }
}