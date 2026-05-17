package com.example.tuniwwayandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 1. Récupération des éléments
        EditText etNom      = findViewById(R.id.etNom);
        EditText etEmail    = findViewById(R.id.etEmailReg);
        EditText etPassword = findViewById(R.id.etPasswordReg);
        Spinner spinnerRole = findViewById(R.id.spinnerRole);
        Button btnRegister  = findViewById(R.id.btnRegister);

        // 2. Initialisation du Spinner avec les rôles
        String[] roles = {"Client", "Guide"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                roles
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRole.setAdapter(adapter);

        // 3. Clic sur le bouton Register
        btnRegister.setOnClickListener(v -> {
            String nom      = etNom.getText().toString().trim();
            String email    = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String role     = spinnerRole.getSelectedItem().toString();

            // 4. Validation des champs vides
            if (nom.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            // 5. Navigation selon le rôle
            Intent intent;
            switch (role) {
                case "Guide":
                    // intent = new Intent(this, GuideActivity.class);
                    // startActivity(intent);
                    Toast.makeText(this, "Bienvenue Guide : " + nom, Toast.LENGTH_SHORT).show();
                    break;
                default: // Client
                    // intent = new Intent(this, MainActivity.class);
                    // startActivity(intent);
                    Toast.makeText(this, "Bienvenue Client : " + nom, Toast.LENGTH_SHORT).show();
                    break;
            }
        });
    }
}