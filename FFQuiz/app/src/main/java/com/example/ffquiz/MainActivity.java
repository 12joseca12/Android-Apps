package com.example.ffquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonA, buttonB, buttonC;
    private TextView textViewPregunta, textViewEnunciado, textViewOpA, textViewOpB, textViewOpC;
    private List<Pregunta> preguntas;
    private int Index;
    private int contAciertos;
    private int contFallos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPregunta=findViewById(R.id.textView);
        imageView=findViewById(R.id.imageView);

        buttonA=findViewById(R.id.button);
        buttonB=findViewById(R.id.button2);
        buttonC=findViewById(R.id.button3);

        textViewEnunciado=findViewById(R.id.textView2);
        textViewOpA=findViewById(R.id.textView3);
        textViewOpB=findViewById(R.id.textView4);
        textViewOpC=findViewById(R.id.textView5);

        preguntas= new ArrayList<>();
        preguntas.add(new Pregunta (getString(R.string.pregunta1), R.drawable.toretto, getString(R.string.enunciado1), getString(R.string.pie1), getString(R.string.pie2), getString(R.string.pie3), buttonA.getId()));
        Index=0;
        mostrarPregunta();
        preguntas.add(new Pregunta (getString(R.string.pregunta2), R.drawable.oconer, getString(R.string.enunciado2), getString(R.string.pie4), getString(R.string.pie5), getString(R.string.pie6), buttonA.getId()));
        preguntas.add(new Pregunta (getString(R.string.pregunta3), R.drawable.leti, getString(R.string.enunciado3), getString(R.string.pie7), getString(R.string.pie8), getString(R.string.pie9), buttonB.getId()));
    }
    private void mostrarPregunta(){
        if (Index<preguntas.size()){
           Pregunta preguntaActual=preguntas.get(Index);
           configurarPregunta(preguntaActual);
        }
        else{
            textViewPregunta.setText("Aciertos: "+contAciertos+"   Errores: "+contFallos);
            imageView.setVisibility(View.GONE);
            buttonA.setVisibility(View.GONE);
            buttonB.setVisibility(View.GONE);
            buttonC.setVisibility(View.GONE);
            textViewEnunciado.setVisibility(View.GONE);
            textViewOpA.setVisibility(View.GONE);
            textViewOpB.setVisibility(View.GONE);
            textViewOpC.setVisibility(View.GONE);
        }
    }

    private void configurarPregunta(Pregunta pregunta){
        textViewPregunta.setText(pregunta.getPregunta());
        textViewEnunciado.setText(pregunta.getEnunciado());
        imageView.setImageResource(pregunta.getIdImagen());
        textViewOpA.setText(pregunta.getPie1());
        textViewOpB.setText(pregunta.getPie2());
        textViewOpC.setText(pregunta.getPie3());
        buttonA.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                comprobarRespuesta(pregunta, buttonA);
            }
        });
        buttonB.setOnClickListener(view -> comprobarRespuesta(pregunta, buttonB));
        buttonC.setOnClickListener(view -> comprobarRespuesta(pregunta, buttonC));
    }

    private void comprobarRespuesta(Pregunta pregunta, Button seleccionado){
        int idRespuestaCorrecta = pregunta.getRespuestaCorrecta();
        if(seleccionado.getId()==idRespuestaCorrecta){
           showToast("Correcto!");
           contAciertos++;
        }
        else{
            showToast("Incorrecto!");
            contFallos++;
        }
        Index++;
        mostrarPregunta();
    }

    private void showToast(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}