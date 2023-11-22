package com.example.examensanchezjosecarlos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    TextView tvFinalSG, tvFinalS1, tvFinalTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Toolbar myt=(Toolbar) findViewById(R.id.tb);
        setSupportActionBar(myt);
        ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Volver");

        Intent i=getIntent();
        int contFSG=i.getIntExtra("contSG",0);
        int contFS1=i.getIntExtra("contS1",0);
        int contFTotal=i.getIntExtra("contTotal",0);

        tvFinalSG=findViewById(R.id.tvFSG);
        tvFinalS1=findViewById(R.id.tvFS1);
        tvFinalTotal=findViewById(R.id.tvFTot);


        String aforoSG=String.valueOf(contFSG);
        String aforoS1=String.valueOf(contFS1);
        String aforoTotal=String.valueOf(contFTotal);

        tvFinalSG.setText("Aforo de la sala general: "+aforoSG);
        tvFinalS1.setText("Aforo del Salon 1: "+aforoS1);
        tvFinalTotal.setText(("Aforo total: "+aforoTotal));
    }
}
