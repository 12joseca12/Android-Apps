package com.example.examensanchezjosecarlos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvcontSG, tvcontS1;
    private Button sumaSG, restaSG, sumaS1, restaS1, btfinal;
    private int contSG=0;
    private int contS1=0;

    private int contTotal=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvcontSG=findViewById(R.id.tvSG);
        tvcontS1=findViewById(R.id.tvS1);

        sumaSG=findViewById(R.id.botonSumaSG);
        restaSG=findViewById(R.id.btRestaSG);
        sumaS1=findViewById(R.id.btSumaS1);
        restaS1=findViewById(R.id.btRestaS1);
        btfinal=findViewById(R.id.btIniciar);

        sumaSG.setOnClickListener(v -> sumarSG());
        restaSG.setOnClickListener(v -> restarSG());
        sumaS1.setOnClickListener(v -> sumarS1());
        restaS1.setOnClickListener(v -> restarS1());
        btfinal.setOnClickListener(v -> total());


    }

    private void sumarSG(){
        if(contSG<40){
            contSG++;
            contTotal++;
            String afo=String.valueOf(contSG);
            tvcontSG.setText(afo);
        }
        else{
            Toast.makeText(this, "Aforo lLeno!", Toast.LENGTH_SHORT).show();
        }
    }

    private void restarSG(){
        if(contSG>0){
            contSG--;
            contTotal--;
            String afor=String.valueOf(contSG);
            tvcontSG.setText(afor);
        }
        else{
            Toast.makeText(this, "Aforo vacío!", Toast.LENGTH_SHORT).show();
        }
    }

    private void sumarS1(){
        if(contS1<15){
            contS1++;
            contTotal++;
            String af=String.valueOf(contS1);
            tvcontS1.setText(af);
        }
        else{
            Toast.makeText(this, "Aforo lLeno!", Toast.LENGTH_SHORT).show();
        }
    }

    private void restarS1(){
        if(contS1>0){
            contS1--;
            contTotal--;
            String aforo=String.valueOf(contS1);
            tvcontS1.setText(aforo);
        }
        else{
            Toast.makeText(this, "Aforo vacío!", Toast.LENGTH_SHORT).show();
        }
    }

    private void total(){
        Intent i=new Intent(this, FinalActivity.class);
        i.putExtra("contSG", contSG);
        i.putExtra("contS1", contS1);
        i.putExtra("contTotal", contTotal);
        startActivity(i);

    }



}