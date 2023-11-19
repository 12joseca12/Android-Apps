package com.example.practicaexamen3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView title, textoBtA, textoBtB, textoBtC;
    ImageView imagen;
    Button btA, btB, btC;
    MediaPlayer mdAcierto, mdFallo;
    int index=0;
    int aciertos=0;
    int fallos=0;

    private List<Pregunta> preguntas=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title=findViewById(R.id.enunciado);
        textoBtA=findViewById(R.id.textVA);
        textoBtB=findViewById(R.id.textVB);
        textoBtC=findViewById(R.id.textVC);
        imagen=findViewById(R.id.img);
        btA=findViewById(R.id.btnA);
        btB=findViewById(R.id.btnB);
        btC=findViewById(R.id.btnC);
        mdAcierto=MediaPlayer.create(this, R.raw.caramba);
        mdFallo=MediaPlayer.create(this, R.raw.nelson);

        Pregunta pregunta1=new Pregunta(getString(R.string.enunciado1), getString(R.string.textVA1), getString(R.string.textVB1), getString(R.string.textVC1), R.drawable.toretto, btB.getId());
        Pregunta pregunta2=new Pregunta(getString(R.string.enunciado2), getString(R.string.textVA2), getString(R.string.textVB2), getString(R.string.textVC2), R.drawable.oconer, btA.getId());
        Pregunta pregunta3=new Pregunta(getString(R.string.enunciado3), getString(R.string.textVA3), getString(R.string.textVB3), getString(R.string.textVC3), R.drawable.leti, btC.getId());

        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);

        mostrar();

    }

    private void mostrar(){
        if(index<preguntas.size()){
            Pregunta preguntaActual=preguntas.get(index);
            configurar(preguntaActual);
        }
        else{
            resultacion();
        }
    }

    private void configurar(Pregunta preguntaActual){
        title.setText(preguntaActual.getEnunciado());
        imagen.setImageResource(preguntaActual.getIdImagen());
        textoBtA.setText(preguntaActual.getTextoOpA());
        textoBtB.setText(preguntaActual.getTextoOpB());
        textoBtC.setText(preguntaActual.getTextoOpC());
        btA.setOnClickListener(view -> comprobar(preguntaActual, btA));
        btB.setOnClickListener(view -> comprobar(preguntaActual, btB));
        btC.setOnClickListener(view -> comprobar(preguntaActual, btC));
    }

    private void comprobar(Pregunta pregunta, Button seleccionado){
        int idCorrecta=pregunta.getOpCorrecta();
        if(seleccionado.getId()==idCorrecta){
            aciertos++;
            Toast.makeText(this, "Correcto!", Toast.LENGTH_SHORT).show();
            mdAcierto.start();
        }
        else{
            fallos++;
            Toast.makeText(this, "Incorrecto!", Toast.LENGTH_SHORT).show();
            mdFallo.start();
        }
        index++;
        mostrar();
    }

    private void resultacion(){
        Intent i=new Intent(this, ResultadoActivity.class);
        i.putExtra("Aciertos", aciertos);
        i.putExtra("Fallos", fallos);
        startActivity(i);
    }

}