package com.example.merca1a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class Onboarding3 extends AppCompatActivity {
    private CircularProgressIndicator progress;
    private View btnNext, container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding3);
        btnNext = findViewById(R.id.btn_next);
        progress = findViewById(R.id.progress_indicator);

        getWindow().setSharedElementEnterTransition(new android.transition.ChangeBounds());
        getWindow().setSharedElementReturnTransition(new android.transition.ChangeBounds());

        // recibe el valor
        int valor = getIntent().getIntExtra("progress_value", 100);

        // se le aplica
        progress.setProgress(valor);
        btnNext.setOnClickListener(v -> { AbrirLogin();});
    }

    public void AbrirLogin(){
        Intent intent = new Intent(Onboarding3.this, Auth.class);
        startActivity(intent);
    }
}