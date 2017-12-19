package com.example.adrlop.fragmentosimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {
    CheckBox aparece;
    View miFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miFrag=(View)findViewById(R.id.ejemplo);
        aparece=(CheckBox)findViewById(R.id.ch1);

        aparece.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){
                if (aparece.isChecked())
                    miFrag.setVisibility(View.VISIBLE);
                else
                    miFrag.setVisibility(View.INVISIBLE);
            }
        });
    }
}
