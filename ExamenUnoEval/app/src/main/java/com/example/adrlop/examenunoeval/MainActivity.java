package com.example.adrlop.examenunoeval;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static class ViewHolder
    {
        TextView nombre;
        TextView descripcion;
        TextView precio;
    }

    private Pizzas[] pizzas = new Pizzas[]{
            new Pizzas("Margarita","York mozarella",12, R.drawable.pizza1),
            new Pizzas("Tres quesos","Queso 1 queso 2 Queso 3",15,R.drawable.pizza2),
            new Pizzas("Barbacoa","Salsa barbacoa bacon",15,R.drawable.pizza3),
            new Pizzas("Italia","Mozarella fresca Albahaca,",20,R.drawable.pizza4)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Bundle paso_datos = new Bundle();
        final EditText unidades = (EditText) findViewById(R.id.editText);


        final String mensaje;
        final Spinner miSpinner = (Spinner) findViewById(R.id.spinner);
        class AdaptadorSpinnerZona extends ArrayAdapter {

            Activity context;

            AdaptadorSpinnerZona(Activity context) {
                super(context, R.layout.spinner_Pizzas, pizzas);
                this.context = context;
            }
            //desplegado del spinner
            public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
                return getView(posicion, convertView, parent);
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                View item = convertView;
                ViewHolder holder;

                //mejora la ejecución. No infla de nuevo
                if (item == null)
                {
                    LayoutInflater inflater = context.getLayoutInflater();
                    item = inflater.inflate(R.layout.spinner_Pizzas, null);

                    holder = new ViewHolder();
                    holder.nombre = (TextView) item.findViewById(R.id.nombre);
                    holder.descripcion = (TextView) item.findViewById(R.id.descripcion);
                    holder.precio = (TextView) item.findViewById(R.id.precio);

                    item.setTag(holder);

                } else {
                    holder = (ViewHolder) item.getTag();
                }

                holder.nombre.setText(pizzas[position].getNombre());
                holder.descripcion.setText(pizzas[position].getNombre());
                String a = Double.toString(pizzas[position].getPrecio());
                holder.precio.setText(a);

                return (item);
            }

        }
        AdaptadorSpinnerZona adaptadorSpin = new AdaptadorSpinnerZona(this);
        miSpinner.setAdapter(adaptadorSpin);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "Pizza elegida: " + pizzas[position].getNombre();
                showToast(mensaje);
                paso_datos.putSerializable("PIZZAS",pizzas[miSpinner.getSelectedItemPosition()]);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Button botonpasar = (Button) findViewById(R.id.button);
        final RadioButton rad1 = (RadioButton) findViewById(R.id.local;
        final RadioButton rad2 = (RadioButton) findViewById(R.id.domicilo);
        final CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);

        botonpasar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double chosed;
                int pos = miSpinner.getSelectedItemPosition();
                double total;
                String unidades = Unidades.getText().toString();
                paso_datos.putString("UNIDADES",unidades);
                String añadido;String tarifa;
                double pe = Double.parseDouble(unidades);

                chosed = pizzas[pos].getPrecio();
                total = comprobar(chosed);
                chosed = tarifas(total);
                String g=Double.toString(chosed);
                añadido = adicional();
                tarifa = tarifa();
                paso_datos.putString("NOMBRE",tarifa);
                paso_datos.putString("DESCRPCION", añadido);
                paso_datos.putString("PRECIO", g);

                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                miIntent.putExtras(paso_datos);
                startActivity(miIntent);
            }

            public String adicional() {
                String respuesta;
                if (cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()) {
                    return respuesta = "+Grande";
                } else if (cb2.isChecked() && !cb1.isChecked() && !cb3.isChecked()) {
                    return respuesta = "+Ingredientes";
                } else if (cb3.isChecked() &&!cb1.isChecked() &&cb2.isChecked()) {
                    return respuesta="Extra de queso";
                }
                else if (cb2.isChecked() && cb1.isChecked()&&cb3.isChecked()) {
                    return respuesta = "+Grande +Ingredientes +ExtraQueso";
                } else
                    return respuesta = "Pizza normal";

            }

            public double tarifas(double Unid) {
                if (cb1.isChecked()) {
                    Unid = Unid + 1;

                } if (cb2.isChecked()) {
                    Unid = Unid + 1.5;
                } if(cb3.isChecked()) {
                    Unid = Unid + 1.5;
                }
                return Unid;
            }

            public double comprobar(double precio) {
                if (rad2.isChecked()){
                    precio = precio + precio * 0.1;
                    return precio;}
                else return precio;
            }
            public String tarifa(){
                String x="";
                if (rad1.isChecked()){
                    x="En local";
                }else if (rad2.isChecked()){
                    x="Envío a Domicilio";
                }
                return x;
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.AcercaDe:
                Intent one = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(one);
                return true;
            case R.id.Dibujo:
                Intent two = new Intent(MainActivity.this, Picture.class);
                startActivity(two);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }
}
