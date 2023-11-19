package com.example.practicaexamen3;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;


public class ResultadoActivity extends AppCompatActivity {

    private TextView txtAciertos, txtFallos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent i=getIntent();
        int aciertos=i.getIntExtra("Aciertos",0);
        int fallos=i.getIntExtra("Fallos", 0);

        txtAciertos=findViewById(R.id.tvAciertos);
        txtFallos=findViewById(R.id.tvFallos);
        txtAciertos.setText("Aciertos: "+aciertos);
        txtFallos.setText("Fallos: "+fallos);

    }









}
