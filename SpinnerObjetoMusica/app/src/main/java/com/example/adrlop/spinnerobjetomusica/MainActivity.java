package com.example.adrlop.spinnerobjetomusica;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Musica[] datos=new Musica[]{
            new Musica("Macarena","Los del Rio",5,R.drawable.rio),
            new Musica("Boomba","King africa",6,R.drawable.king),
            new Musica("Mi carro me lo robaron","Manolo Escobar",3,R.drawable.manolo)

    };

    static class ViewHolder{
        TextView Titulo;
        TextView Autor;
        TextView Duracion;
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

class AdaptadorMusica extends ArrayAdapter<Musica>{
    public Activity miActividad;

    public AdaptadorMusica(Activity laActividad){
        super(laActividad,R.layout.spinnermusica,datos);
        this.miActividad=laActividad;
    }
    public View getDrop
}