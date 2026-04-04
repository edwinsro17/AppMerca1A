package com.example.merca1a;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    View logo, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);

        // 🔥 Animación del logo
        logo.animate()
                .alpha(1f)
                .translationY(-50)
                .setDuration(800)
                .setInterpolator(new DecelerateInterpolator())
                .start();

        // 🔥 Animación del texto
        title.animate()
                .alpha(1f)
                .translationY(-30)
                .setDuration(800)
                .setStartDelay(200)
                .setInterpolator(new DecelerateInterpolator())
                .start();

        // ⏳ Esperar 1 segundo y pasar a onboarding
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash.this, Onboarding1.class);
            startActivity(intent);
            finish(); // 🔥 evita volver atrás
        }, 1000);
    }
}
