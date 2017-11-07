package com.example.adrlop.spinnermatriz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SpinnerInfo());
    }

    private void showToast(String text){
        Toast.makeText(this, text,Toast.LENGTH_LONG).show();
    }

    private class SpinnerInfo implements A
}
