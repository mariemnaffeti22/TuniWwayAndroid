package com.example.tuniwwayandroid.admin;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuniwwayandroid.R;
import com.example.tuniwwayandroid.firebase.FirebaseHelper;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AdminActivity extends AppCompatActivity {

    TextView txtClientsCount, txtGuidesCount, txtToursCount, txtCategoriesCount;
    Button btnAddCategory;

    FirebaseFirestore db;
    TextView txtCategoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        txtClientsCount = findViewById(R.id.txtClientsCount);
        txtGuidesCount = findViewById(R.id.txtGuidesCount);
        txtToursCount = findViewById(R.id.txtToursCount);
        txtCategoriesCount = findViewById(R.id.txtCategoriesCount);
        btnAddCategory = findViewById(R.id.btnAddCategory);

        db = FirebaseHelper.getDatabase();

        loadStats();

        btnAddCategory.setOnClickListener(v -> showAddCategoryDialog());

        txtCategoriesList = findViewById(R.id.txtCategoriesList);
    }

    private void loadStats() {
        db.collection("users")
                .whereEqualTo("role", "client")
                .get()
                .addOnSuccessListener(querySnapshot -> {
                    txtClientsCount.setText("Clients : " + querySnapshot.size());
                });

        db.collection("users")
                .whereEqualTo("role", "guide")
                .get()
                .addOnSuccessListener(querySnapshot -> {
                    txtGuidesCount.setText("Guides : " + querySnapshot.size());
                });

        db.collection("tours")
                .get()
                .addOnSuccessListener(querySnapshot -> {
                    txtToursCount.setText("Tours : " + querySnapshot.size());
                });

        db.collection("categories")
                .get()
                .addOnSuccessListener(querySnapshot -> {
                    txtCategoriesCount.setText("Catégories : " + querySnapshot.size());

                    StringBuilder builder = new StringBuilder();
                    builder.append("Liste des catégories :\n\n");

                    querySnapshot.forEach(document -> {
                        String name = document.getString("name");
                        if (name != null) {
                            builder.append("- ").append(name).append("\n");
                        }
                    });

                    txtCategoriesList.setText(builder.toString());
                });
    }

    private void showAddCategoryDialog() {
        EditText input = new EditText(this);
        input.setHint("Nom de la catégorie");

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Ajouter une catégorie")
                .setView(input)
                .setPositiveButton("Ajouter", null)
                .setNegativeButton("Annuler", null)
                .create();

        dialog.setOnShowListener(dialogInterface -> {
            Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

            button.setOnClickListener(v -> {
                String categoryName = input.getText().toString().trim();

                if (categoryName.isEmpty()) {
                    input.setError("Veuillez entrer un nom");
                } else {
                    addCategory(categoryName);
                    dialog.dismiss();
                }
            });
        });

        dialog.show();
    }

    private void addCategory(String categoryName) {
        Map<String, Object> category = new HashMap<>();
        category.put("name", categoryName);
        category.put("icon", "default");

        db.collection("categories")
                .add(category)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Catégorie ajoutée", Toast.LENGTH_SHORT).show();
                    loadStats();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Erreur : " + e.getMessage(), Toast.LENGTH_LONG).show();
                });
    }
}