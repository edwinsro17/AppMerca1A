package com.example.merca1a;

import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class Onboarding2 extends AppCompatActivity {

    private CircularProgressIndicator progress;
    private View btnNext, container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);
        btnNext = findViewById(R.id.btn_next);
        container = findViewById(R.id.container_button);
        progress = findViewById(R.id.progress_indicator);

        getWindow().setSharedElementEnterTransition(new android.transition.ChangeBounds());
        getWindow().setSharedElementReturnTransition(new android.transition.ChangeBounds());

        // recibe el valor
        int valor = getIntent().getIntExtra("progress_value", 66);

        // se le aplica
        progress.setProgress(valor);

        btnNext.setOnClickListener(v -> { AbrirOnboarding3();});
    }

    public void AbrirOnboarding3(){
        // animación del progreso de 66 a 100
        ObjectAnimator animator = ObjectAnimator.ofInt(progress, "progress", 66, 100);
        animator.setDuration(150);
        animator.start();

        // se espera que termine la animación
        new Handler().postDelayed(() -> {

            Intent intent = new Intent(Onboarding2.this, Onboarding3.class);

            // aqui le pasamos el valor
            intent.putExtra("progress_value", 100);

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                    Onboarding2.this,
                    Pair.create(container, "transicion_boton")
            );

            startActivity(intent, options.toBundle());

        }, 150); // mismo tiempo que la animación
    }
}