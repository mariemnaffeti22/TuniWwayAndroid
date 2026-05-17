package com.example.tuniwwayandroid.explore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tuniwwayandroid.R;

public class DestinationDetailActivity extends AppCompatActivity {

    TextView txtDestinationName, txtDescription;
    ImageView imgDestination;
    Button btnMaps, btnSms, btnShare;

    String destinationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_detail);

        txtDestinationName = findViewById(R.id.txtDestinationName);
        txtDescription = findViewById(R.id.txtDescription);
        imgDestination = findViewById(R.id.imgDestination);
        btnMaps = findViewById(R.id.btnMaps);
        btnSms = findViewById(R.id.btnSms);
        btnShare = findViewById(R.id.btnShare);

        destinationName = getIntent().getStringExtra("category");

        if (destinationName == null) {
            destinationName = "Tunisie";
        }

        txtDestinationName.setText(destinationName);
        txtDescription.setText("Découvrez les meilleures destinations de la catégorie : " + destinationName);

        btnMaps.setOnClickListener(v -> {
            Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(destinationName + " Tunisie"));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:+21612345678"));
            intent.putExtra("sms_body", "Bonjour, je veux plus d'informations sur : " + destinationName);
            startActivity(intent);
        });

        btnShare.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Découvrez cette destination sur TuniWway : " + destinationName);
            startActivity(Intent.createChooser(intent, "Partager avec"));
        });
    }
}