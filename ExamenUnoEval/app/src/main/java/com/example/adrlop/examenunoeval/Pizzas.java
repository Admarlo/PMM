package com.example.adrlop.examenunoeval;

/**
 * Created by adrlop on 17/11/17.
 */

public class Pizzas {

    private String Nombre;
    private String Descripcion;
    private int Precio;
    private int Imagen;

    public Pizzas(){
        this.Nombre="nombre";
        this.Descripcion="descripcion";
        this.Precio=0;
        this.Imagen=0;
    }
    public Pizzas(String nombre, String descripcion, int precio, int imagen){
        this.Nombre=nombre;
        this.Descripcion=descripcion;
        this.Precio=precio;
        this.Imagen=imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getPrecio() {
        return Precio;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setDescripcion(String marca) {
        Descripcion = marca;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    @Override
    public String toString() {
        String cadena;
        cadena="Nombre: "+Nombre+"\tDescripción: "+Descripcion+"\tPrecio: "+Integer.valueOf(Precio);
        return cadena;
    }
}
