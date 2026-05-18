package com.example.tuniwwayandroid;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToursActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTours;
    private TourAdapter tourAdapter;
    private List<Tour> tourList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);

        // 1. Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. RecyclerView
        recyclerViewTours = findViewById(R.id.recyclerViewTours);
        recyclerViewTours.setLayoutManager(new LinearLayoutManager(this));

        // 3. Données avec images
        tourList = new ArrayList<>();
        tourList.add(new Tour("Bizerte", "14/06/2026", 150.0, "Ahmed Ben Ali", R.drawable.bizerte));
        tourList.add(new Tour("Sidi Bou Said", "20/06/2026", 200.0, "Fatma Trabelsi", R.drawable.sidibou));
        tourList.add(new Tour("Djerba", "25/06/2026", 350.0, "Mohamed Sassi", R.drawable.jerba));
        tourList.add(new Tour("Tozeur", "01/07/2026", 400.0, "Leila Mansour", R.drawable.touzeur));
        tourList.add(new Tour("Sousse", "05/07/2026", 180.0, "Karim Bouazizi", R.drawable.sousse));

        // 4. Adapter
        tourAdapter = new TourAdapter(tourList);
        recyclerViewTours.setAdapter(tourAdapter);

        // 5. Charger les taux de conversion
        loadConversionRates();
    }

    private void loadConversionRates() {
        ApiService apiService = ApiClient.getApiService();
        Call<ExchangeResponse> call = apiService.getConversionRates("d7c9bb6990939f577094162d");

        call.enqueue(new Callback<ExchangeResponse>() {
            // Dans la méthode onResponse de ToursActivity :
            @Override
            public void onResponse(Call<ExchangeResponse> call, Response<ExchangeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    double taux = response.body().getConversionRates().getUsd();

                    // Mettre à jour chaque tour avec son prix en USD
                    for (Tour t : tourList) {
                        t.setPrixUsd(t.getPrix() * taux);
                    }

                    // Rafraîchir l'affichage
                    tourAdapter.notifyDataSetChanged();
                    Toast.makeText(ToursActivity.this, "Prix convertis en USD !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ExchangeResponse> call, Throwable t) {
                Toast.makeText(ToursActivity.this,
                        "Erreur API : " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Rafraîchir");
        menu.add(0, 2, 1, "À propos de");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            Toast.makeText(this, "Liste rafraîchie !", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 2) {
            new AlertDialog.Builder(this)
                    .setTitle("À propos de")
                    .setMessage("TuniWway — Explorez la Tunisie\nVersion 1.0")
                    .setPositiveButton("OK", null)
                    .show();
        }
        return true;
    }
}