package com.example.adrlop.botones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para controlar el cambio de pantalla
        final Button boton1=(Button)findViewById(R.id.boton1);
        final Button boton2=(Button)findViewById(R.id.boton2);
        final Button boton3=(Button)findViewById(R.id.boton3);
        final Button boton4=(Button)findViewById(R.id.boton4);
        final Button boton5=(Button)findViewById(R.id.boton5);
        final Button boton6=(Button)findViewById(R.id.boton6);

        //realiza la accion del boton.
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent=new Intent(MainActivity.this, Lineal.class);
                startActivity(miIntent);
        }
    });
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent=new Intent(MainActivity.this, Table.class);
                startActivity(miIntent);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent=new Intent(MainActivity.this, Relative.class);
                startActivity(miIntent);
            }
        });

        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent=new Intent(MainActivity.this, Grid.class);
                startActivity(miIntent);
            }
        });

        boton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent=new Intent(MainActivity.this, checkBox.class);
                startActivity(miIntent);
            }
        });

        boton6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent miIntent=new Intent(MainActivity.this, Radio.class);
                startActivity(miIntent);
            }
        });
    }
}
