package com.example.adrlop.aminaciones;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animacion;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Obtenemos el recurso creado en animacion.xml
        animacion = (AnimationDrawable) getResources().getDrawable(R.drawable.animation);
        //Creamos una vista que contendrá una imagen
        ImageView imagen = new ImageView(this);
        imagen.setBackgroundColor(Color.WHITE); //Le ponemos color de fondo
        imagen.setImageDrawable(animacion); //Cargamos una animación.
        setContentView(imagen);
    }
    public boolean onTouchEvent(MotionEvent evento) {
        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            animacion.start(); //Ponemos en marcha la animación
            return true;
        }
        return super.onTouchEvent(evento);
    }
}

