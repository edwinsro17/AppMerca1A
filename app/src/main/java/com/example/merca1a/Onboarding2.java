package com.example.merca1a;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class Onboarding2 extends AppCompatActivity {

    private CircularProgressIndicator progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);

        progress = findViewById(R.id.progress_indicator);

        getWindow().setSharedElementEnterTransition(new android.transition.ChangeBounds());
        getWindow().setSharedElementReturnTransition(new android.transition.ChangeBounds());

        // recibe el valor
        int valor = getIntent().getIntExtra("progress_value", 66);

        // se le aplica
        progress.setProgress(valor);
    }
}