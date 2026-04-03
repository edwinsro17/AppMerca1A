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

public class Onboarding1 extends AppCompatActivity {

    private View btnNext, container;
    private CircularProgressIndicator progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);

        btnNext = findViewById(R.id.btn_next);
        container = findViewById(R.id.container_button);
        progress = findViewById(R.id.progress_indicator);

        getWindow().setSharedElementEnterTransition(new android.transition.ChangeBounds());
        getWindow().setSharedElementReturnTransition(new android.transition.ChangeBounds());

        btnNext.setOnClickListener(v -> { AbrirOnboarding2();});
    }

    public void AbrirOnboarding2(){
        // animación del progreso de 33 a 66
        ObjectAnimator animator = ObjectAnimator.ofInt(progress, "progress", 33, 66);
        animator.setDuration(500);
        animator.start();

        // se espera que termine la animación
        new Handler().postDelayed(() -> {

            Intent intent = new Intent(Onboarding1.this, Onboarding2.class);

            // aqui le pasamos el valor
            intent.putExtra("progress_value", 66);

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                    Onboarding1.this,
                    Pair.create(container, "transicion_boton")
            );

            startActivity(intent, options.toBundle());

        }, 500); // mismo tiempo que la animación
    }
}
