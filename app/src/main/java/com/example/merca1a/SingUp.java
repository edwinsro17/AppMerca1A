package com.example.merca1a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SingUp extends AppCompatActivity {
    private EditText et_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sing_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tv_sing_in = findViewById(R.id.tv_sing_in);
        tv_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {abrirSingIn();}
        });
        ImageView btn_retroceder = findViewById(R.id.btn_retroceder);
        btn_retroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirAuth();
            }
        });
        et_nombre = findViewById(R.id.et_nombre);
        Button btn_registrar = findViewById(R.id.btn_registrar);
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirWelcome();
            }
        });

    }
    public void abrirAuth(){
        Intent i =new Intent(this, Auth.class);
        startActivity(i);
    }
    public void abrirWelcome(){
        Intent i =new Intent(this, Welcome.class);
        i.putExtra("nombre", et_nombre.getText().toString());
        startActivity(i);
    }
    public void abrirSingIn(){
        Intent i =new Intent(this, Login.class);
        startActivity(i);
    }
}