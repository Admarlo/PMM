package com.example.adrlop.preferencias_aplica_bici;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PantallaOpciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.app.FragmentTransaction ft =getFragmentManager().beginTransaction();
        ft.add(android.R.id.content,new SettingsFragment());
        ft.commit();
    }
}
