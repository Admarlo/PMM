package com.example.usuario.recopilatorio;

import java.io.Serializable;

public class Destino implements Serializable{
    private String zona;
    private String continente;
    private double precio;
    private int imagen;

    public Destino(String zona, String continente, double precio, int imagen) {
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
        this.imagen = imagen;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getZona() {
        return zona;
    }

    public String getContinente() {
        return continente;
    }

    public double getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
