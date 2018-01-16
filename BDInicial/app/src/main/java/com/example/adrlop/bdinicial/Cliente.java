package com.example.adrlop.bdinicial;

/**
 * Created by adrlop on 16/01/18.
 */

public class Cliente {

    private String Nombre;
    private String Telefono;

    public Cliente(String nombre, String telefono){
        Nombre=nombre;
        Telefono=telefono;
    }

    public String getNombre(){
        return Nombre;
    }
    public void setTitulo(String nombre){
        Nombre=nombre;
    }
    public String getTelefono(){
        return Telefono;
    }
    public void setTelefono(String telefono){
        Telefono=telefono;
    }
}
