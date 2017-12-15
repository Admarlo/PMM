package com.example.adrlop.spinnerobjetomusica;

/**
 * Created by adrlop on 28/11/17.
 */

public class Musica {

    private String Titulo;
    private String Autor;
    private int Duracion;
    private int Imagen;

//    public Musica(){
//        this.Titulo="titulo";
//        this.Autor="autor";
//        this.Duracion=0;
//        this.Imagen=0;
//    }
    public Musica(String titulo,String autor,int duracion, int imagen){
        this.Titulo=titulo;
        this.Autor=autor;
        this.Duracion=duracion;
        this.Imagen=imagen;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
    //  @Override
//    public String toString() {
//        String cadena;
//        cadena="Titulo Canción: "+Titulo+"\tAutor: "+Autor+"\tDuración: "+Integer.valueOf(Duracion)+"minutos";
//        return cadena;
//    }
}
