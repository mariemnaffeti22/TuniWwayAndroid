package com.example.tuniwwayandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. Récupérer les vues
        TextView tvRegister = findViewById(R.id.tvRegister);
        EditText etEmail    = findViewById(R.id.etEmailLogin);
        Button btnLogin     = findViewById(R.id.btnLogin);

        // 2. Clic sur "S'inscrire" → aller vers RegisterActivity
        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // 3. Clic sur "Se connecter" → navigation selon le rôle
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();

            if (email.contains("admin")) {
                Toast.makeText(this, "Bienvenue Admin", Toast.LENGTH_SHORT).show();
                // Intent vers AdminActivity quand elle sera créée
                // Intent intent = new Intent(this, AdminActivity.class);
                // startActivity(intent);
                // finish();

            } else if (email.contains("guide")) {
                Toast.makeText(this, "Bienvenue Guide", Toast.LENGTH_SHORT).show();
                // Intent vers GuideActivity quand elle sera créée

            } else {
                Toast.makeText(this, "Bienvenue Client", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}