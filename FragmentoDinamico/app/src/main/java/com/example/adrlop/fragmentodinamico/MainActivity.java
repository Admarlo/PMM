package com.example.adrlop.fragmentodinamico;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int mStackPosition = 1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BotÃ³n de aÃ±adir fragments
        Button button = (Button)findViewById(R.id.newFragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addFragment();
            }
        });

        if (savedInstanceState == null) {
            // aÃ±adir el primer fragment
            Fragment newFragment = Fragmento.newInstance(mStackPosition);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragmentShow, newFragment).commit();
        } else {
            mStackPosition = savedInstanceState.getInt("position");
        }
    }

    void addFragment() {
        mStackPosition++;
        // Instanciamos nuevo Fragment
        Fragment newFragment = Fragmento.newInstance(mStackPosition);
        // Se aÃ±ade el Fragment a la actividad
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // aÃ±adimos la transaciÃ³n a la pila
        ft.addToBackStack(null);
        ft.commit();
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("position",mStackPosition);
    }

}
