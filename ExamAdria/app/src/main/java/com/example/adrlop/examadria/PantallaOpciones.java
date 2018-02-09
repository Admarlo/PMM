package com.example.adrlop.examadria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PantallaOpciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_opciones);
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, new SettingsFragment());
        ft.commit();
    }
}

