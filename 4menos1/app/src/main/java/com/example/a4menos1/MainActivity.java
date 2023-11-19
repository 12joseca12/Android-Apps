package com.example.a4menos1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mdAciertos, mdFallos;
    private TextView title;
    private ImageView imagen1, imagen2, imagen3, imagen4;
    private Button siguiente, finalizar, volver;
    private List<Pregunta> preguntas=new ArrayList<>();
    private int index=0;
    private int aciertos=0;
    private int fallos=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdAciertos=MediaPlayer.create(this, R.raw.caramba);
        mdFallos=MediaPlayer.create(this, R.raw.nelson);

        title=findViewById(R.id.titulo);
        imagen1=findViewById(R.id.img1);
        imagen2=findViewById(R.id.img2);
        imagen3=findViewById(R.id.img3);
        imagen4=findViewById(R.id.img4);
        siguiente=findViewById(R.id.siguiente);
        finalizar=findViewById(R.id.finalizar);
        volver=findViewById(R.id.volver);

        Pregunta pregunta1=new Pregunta(R.drawable.sl1, R.drawable.sl2, R.drawable.sl3, R.drawable.sl4, R.drawable.sl4);
        Pregunta pregunta2=new Pregunta(R.drawable.tn1, R.drawable.tn2, R.drawable.tn3, R.drawable.tn4, R.drawable.tn4);
        Pregunta pregunta3=new Pregunta(R.drawable.trb1, R.drawable.trb2, R.drawable.trb3, R.drawable.trb4, R.drawable.trb4);

        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);

        pintar(preguntas, index);

        imagen1.setOnClickListener(view -> comprobacion(preguntas.get(index), preguntas.get(index).getIdImagen1()));
        imagen2.setOnClickListener(view -> comprobacion(preguntas.get(index), preguntas.get(index).getIdImagen2()));
        imagen3.setOnClickListener(view -> comprobacion(preguntas.get(index), preguntas.get(index).getIdImagen3()));
        imagen4.setOnClickListener(view -> comprobacion(preguntas.get(index), preguntas.get(index).getIdImagen4()));

        finalizar.setOnClickListener(view -> {
            Intent i=new Intent(this, ResultadoActivity.class);
            i.putExtra("aciertos", aciertos);
            i.putExtra("fallos", fallos);
            startActivity(i);
        });

        siguiente.setOnClickListener(view -> avanzar(preguntas));
        volver.setOnClickListener(view -> retroceder(preguntas));



    }

    private void pintar(List<Pregunta> preguntas, int index){
        imagen1.setImageResource(preguntas.get(index).getIdImagen1());
        imagen2.setImageResource(preguntas.get(index).getIdImagen2());
        imagen3.setImageResource(preguntas.get(index).getIdImagen3());
        imagen4.setImageResource(preguntas.get(index).getIdImagen4());
    }

    private void avanzar(List<Pregunta> preguntas){
        if(index<preguntas.size()-1){
            index++;
            pintar(preguntas, index);
        }
        else{
            Toast.makeText(this, "No quedan más preguntas", Toast.LENGTH_SHORT).show();
        }
    }

    private void retroceder(List<Pregunta> preguntas){
        if (index>0){
            index--;
            pintar(preguntas, index);
        }
        else{
            Toast.makeText(this, "Estas en la primera pregunta", Toast.LENGTH_SHORT).show();
        }
    }

    private void comprobacion(Pregunta p, int id){
        if (p.getIdCorrecta()==id){
            aciertos++;
            Toast.makeText(this, "Correcto!", Toast.LENGTH_SHORT).show();
            mdAciertos.start();
        }
        else{
            fallos++;
            Toast.makeText(this, "Incorrecto!", Toast.LENGTH_SHORT).show();
            mdFallos.start();
        }
    }

}