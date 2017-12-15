package com.example.adrlop.preferencias_aplica_bici;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by adrlop on 15/12/17.
 */

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
    }
}
