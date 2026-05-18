package com.example.tuniwwayandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tuniwwayandroid.admin.AdminActivity;
import com.example.tuniwwayandroid.explore.ExploreActivity;

public class MainActivity extends AppCompatActivity {

    Button btnExplore, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExplore = findViewById(R.id.btnExplore);
        btnAdmin = findViewById(R.id.btnAdmin);

        btnExplore.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
            startActivity(intent);
        });

        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdminActivity.class);
            startActivity(intent);
        });
    }
}