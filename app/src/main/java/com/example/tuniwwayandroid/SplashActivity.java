package com.example.tuniwwayandroid;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Attendre 2 secondes (2000 ms) puis lancer LoginActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Note : LoginActivity n'existe pas encore, donc cela va surligner en rouge.
                // C'est normal ! Nous la créerons dans la tâche suivante.
                Intent intent = new Intent(SplashActivity.this, MainActivity.class); // Temporairement MainActivity
                startActivity(intent);
                finish(); // Empêche l'utilisateur de revenir sur le splash
            }
        }, 2000);
    }
}