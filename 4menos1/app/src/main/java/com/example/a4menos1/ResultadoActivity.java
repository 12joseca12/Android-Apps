package com.example.a4menos1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class ResultadoActivity extends AppCompatActivity {
    TextView textaciertos, textfallos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Volver");
        }

        setContentView(R.layout.activity_resultado);
        textaciertos=findViewById(R.id.txtAciertos);
        textfallos=findViewById(R.id.txtFallos);
        Intent i=getIntent();
        int aciertos=i.getIntExtra("aciertos", 0);
        int fallos=i.getIntExtra("fallos", 0);
        textaciertos.setText("Aciertos: "+aciertos);
        textfallos.setText("Fallos: "+fallos);
    }
}