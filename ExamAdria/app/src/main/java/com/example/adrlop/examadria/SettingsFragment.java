package com.example.adrlop.examadria;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by adrlop on 9/02/18.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
    }
}
