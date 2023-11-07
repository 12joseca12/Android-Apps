package com.example.ejrepaso1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView titulo;
    private ImageView imagen1, imagen2, imagen3, imagen4;
    private Button butonSiguiente, butonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociar variables a vistas

        titulo=findViewById(R.id.tituloApp);
        imagen1=findViewById(R.id.imagen1);
        imagen2=findViewById(R.id.imagen2);
        imagen3=findViewById(R.id.imagen3);
        imagen4=findViewById(R.id.imagen4);

        butonSiguiente= findViewById(R.id.button5);
        butonFinalizar= findViewById(R.id.button6);

        //crear preguntas con su constructor
        Pregunta p1=new Pregunta(R.drawable.coche1, R.drawable.coche2,R.drawable.coche3, R.drawable.coche4, R.drawable.coche4);
        Pregunta p2=new Pregunta(R.drawable.drift1, R.drawable.drift2,R.drawable.drift3, R.drawable.drift4, R.drawable.drift4);
        Pregunta p3=new Pregunta(R.drawable.leon1, R.drawable.leon2,R.drawable.leon3, R.drawable.leon4, R.drawable.leon4);

        //crear lista preguntas y añadir a la lista
        ArrayList<Pregunta> listaPreguntas =new ArrayList<Pregunta>();
        int index=0;
        listaPreguntas.add(p1);
        listaPreguntas.add(p2);
        listaPreguntas.add(p3);

        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen1());
        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen2());
        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen3());
        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen4());


        //pintar layout de la primera pregunta
        pintar(listaPreguntas,index);

        //evaluar si la pregunta es correcta o pulso next

        butonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

        private void pintar(ArrayList <Pregunta> a, int indice){
            imagen1.setImageResource(a.get(indice).getIdImagen1());
            imagen2.setImageResource(a.get(indice).getIdImagen2());
            imagen3.setImageResource(a.get(indice).getIdImagen3());
            imagen4.setImageResource(a.get(indice).getIdImagen4());

        }
/*
        private int iterar(int index, ArrayList<Pregunta> a){
           if(0 <= index && index < a.size()){

               pintar(a, index);
               index++;
           }
           return index;
        }

    private int retornar(int index, ArrayList<Pregunta> a){
        if(0 <= index && index < a.size()){
            index--;
            pintar(a, index);
        }
        return index;
    }

 */

}