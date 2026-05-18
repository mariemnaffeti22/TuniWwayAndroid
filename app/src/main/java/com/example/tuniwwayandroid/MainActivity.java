package com.example.tuniwwayandroid;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Redirection vers ToursActivity
        Intent intent = new Intent(this, ToursActivity.class);
        startActivity(intent);
        finish();
    }
}