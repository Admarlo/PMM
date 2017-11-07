package com.example.adrlop.listasdeverdad;

/**
 * Created by adrlop on 20/10/17.
 */

public class Titular {

    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String tit, String sub, int act){
        titulo = tit;
        subtitulo = sub;
        imagen = act;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }

    public int getImagen() {
        return imagen;
    }
}
