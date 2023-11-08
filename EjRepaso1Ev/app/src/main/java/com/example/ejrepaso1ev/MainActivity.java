package com.example.ejrepaso1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView titulo;
    private ImageView imagen1, imagen2, imagen3, imagen4;
    private Button butonSiguiente, butonFinalizar, butonRetroceder;
    private int index=0;
    private int aciertos, fallos;


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
        butonRetroceder=findViewById(R.id.button7);

        //crear preguntas con su constructor
        Pregunta p1=new Pregunta(R.drawable.coche1, R.drawable.coche2,R.drawable.coche3, R.drawable.coche4, R.drawable.coche4);
        Pregunta p2=new Pregunta(R.drawable.drift1, R.drawable.drift2,R.drawable.drift3, R.drawable.drift4, R.drawable.drift4);
        Pregunta p3=new Pregunta(R.drawable.leon1, R.drawable.leon2,R.drawable.leon3, R.drawable.leon4, R.drawable.leon4);

        //crear lista preguntas y añadir a la lista
        ArrayList<Pregunta> listaPreguntas =new ArrayList<Pregunta>();
        listaPreguntas.add(p1);
        listaPreguntas.add(p2);
        listaPreguntas.add(p3);

        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen1());
        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen2());
        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen3());
        imagen1.setImageResource(listaPreguntas.get(0).getIdImagen4());


        //pintar layout de la primera pregunta
        pintar(listaPreguntas,index);


          //metodos onclick para los botones
        butonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iterar(listaPreguntas);
            }
        });

        butonRetroceder.setOnClickListener(view -> retornar(listaPreguntas));

        //pulsacion de imagenes

        imagen1.setOnClickListener(view -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen1()));
        imagen2.setOnClickListener(view -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen2()));
        imagen3.setOnClickListener(view -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen3()));
        imagen4.setOnClickListener(view -> verificarRespuesta(listaPreguntas.get(index), listaPreguntas.get(index).getIdImagen4()));

        butonFinalizar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PantallaFinal.class);
            intent.putExtra("aciertos", aciertos);
            intent.putExtra("fallos", fallos);
            startActivity(intent);
        });
    }

        private void pintar(ArrayList <Pregunta> a, int indice){
            imagen1.setImageResource(a.get(indice).getIdImagen1());
            imagen2.setImageResource(a.get(indice).getIdImagen2());
            imagen3.setImageResource(a.get(indice).getIdImagen3());
            imagen4.setImageResource(a.get(indice).getIdImagen4());

        }

        private void iterar( ArrayList<Pregunta> a){
           if(0 <= index && index < a.size()-1){
               index++;
               pintar(a, index);
           }

        }

    private void retornar( ArrayList<Pregunta> a){
        if(0 <= index && index < a.size()-1){
            index--;
            pintar(a, index);
        }

    }

    private void verificarRespuesta(Pregunta p, int id){
        if(p.getCorrecta()==id){
            aciertos++;
            Toast.makeText(MainActivity.this, "Has encontrado al impostor", Toast.LENGTH_SHORT).show();
        }
        else{
            fallos++;
            Toast.makeText(MainActivity.this, "UPS", Toast.LENGTH_SHORT).show();
        }
    }





}