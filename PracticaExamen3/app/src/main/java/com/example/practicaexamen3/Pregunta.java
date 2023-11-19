package com.example.practicaexamen3;

public class Pregunta {
    private int opCorrecta, idImagen;
    private String enunciado, textoOpA, textoOpB, textoOpC;

    public Pregunta(String enunciado, String textoOpA, String textoOpB, String textoOpC, int idImagen, int opCorrecta){
        this.enunciado=enunciado;
        this.textoOpA=textoOpA;
        this.textoOpB=textoOpB;
        this.textoOpC=textoOpC;
        this.idImagen=idImagen;
        this.opCorrecta=opCorrecta;
    }

    public int getOpCorrecta() {
        return opCorrecta;
    }

    public void setOpCorrecta(int opCorrecta) {
        this.opCorrecta = opCorrecta;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTextoOpA() {
        return textoOpA;
    }

    public void setTextoOpA(String textoOpA) {
        this.textoOpA = textoOpA;
    }

    public String getTextoOpB() {
        return textoOpB;
    }

    public void setTextoOpB(String textoOpB) {
        this.textoOpB = textoOpB;
    }

    public String getTextoOpC() {
        return textoOpC;
    }

    public void setTextoOpC(String textoOpC) {
        this.textoOpC = textoOpC;
    }
}
