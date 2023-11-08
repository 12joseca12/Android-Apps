package com.example.ejrepaso1ev;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PantallaFinal extends AppCompatActivity {

    private TextView textAciertos, textFallos;
    private int aciertos, fallos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        textAciertos = findViewById(R.id.aciertostextview);
        textFallos=findViewById(R.id.fallostextview);

        Intent intent=getIntent();
        if(intent!=null){
            aciertos=intent.getIntExtra("aciertos", 0);
            fallos=intent.getIntExtra("fallos", 0);
            String stringaciertos ="Aciertos "+String.valueOf(aciertos);
            String stringfallos ="Fallos "+String.valueOf(fallos);
            textAciertos.setText(stringaciertos);
            textFallos.setText(stringfallos);
        }


    }
}