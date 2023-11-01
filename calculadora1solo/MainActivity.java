package com.example.calculadora1solo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=findViewById(R.id.editTextNumberDecimal);
        num2=findViewById(R.id.editTextNumberDecimal2);
        resultado=findViewById(R.id.textView2);
        Button sum=findViewById(R.id.button);
        Button rest=findViewById(R.id.button2);
        Button mult=findViewById(R.id.button3);
        Button div=findViewById(R.id.button4);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suma();
            }
        });

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resta();
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicacion();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                division();
            }
        });

    }

    private void suma(){
        double n1=Double.parseDouble(num1.getText().toString());
        double n2=Double.parseDouble(num2.getText().toString());
        double res=n1+n2;
        resultado.setText("Resultado suma: "+res);
    }
    private void resta(){
        double n1=Double.parseDouble(num1.getText().toString());
        double n2=Double.parseDouble(num2.getText().toString());
        double res=n1-n2;
        resultado.setText("Resultado resta: "+res);
    }

    private void multiplicacion(){
        double n1=Double.parseDouble(num1.getText().toString());
        double n2=Double.parseDouble(num2.getText().toString());
        double res=n1*n2;
        resultado.setText("Resultado mulltiplicacion: "+res);
    }

    private void division(){
        double n1=Double.parseDouble(num1.getText().toString());
        double n2=Double.parseDouble(num2.getText().toString());
        if(n2!=0){
            double res=n1/n2;
            resultado.setText("Resultado division: "+res);
        }
        else{
            resultado.setText("No se puede dividir por cero");
        }
    }
}