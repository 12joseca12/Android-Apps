package com.example.ffquiz;

public class Pregunta {
    private String pregunta;
    private int idImagen;
    private String enunciado;
    private String pie1;
    private String pie2;
    private String pie3;
    private int respuestaCorrecta;



    public Pregunta(String pregunta, int idImagen, String enunciado, String pie1, String pie2, String pie3, int respuestaCorrecta){
        this.pregunta=pregunta;
        this.idImagen=idImagen;
        this.enunciado=enunciado;
        this.pie1=pie1;
        this.pie2=pie2;
        this.pie3=pie3;
        this.respuestaCorrecta=respuestaCorrecta;
    }
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getPie1() {
        return pie1;
    }

    public void setPie1(String pie1) {
        this.pie1 = pie1;
    }

    public String getPie2() {
        return pie2;
    }

    public void setPie2(String pie2) {
        this.pie2 = pie2;
    }

    public String getPie3() {
        return pie3;
    }

    public void setPie3(String pie3) {
        this.pie3 = pie3;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
}
