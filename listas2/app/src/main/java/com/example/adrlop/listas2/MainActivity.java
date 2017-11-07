package com.example.adrlop.listas2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lstOpciones;
    final static String semana[]={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;
        lstOpciones=(ListView)findViewById(R.id.LstOpciones);

        ArrayAdapter<String>miAdaptador=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,semana);
        lstOpciones.setAdapter(miAdaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int posicion, long id){
                String mensaje="";
                mensaje="Item clicked=>"+semana[posicion];
                showToast(mensaje);
            }


       public void onNothingSelected(AdapterView<?>adapterView){
       }
        });
    }
    public void showToast(String text){
        Toast.makeText(this, text,Toast.LENGTH_SHORT).show();
    }
}
