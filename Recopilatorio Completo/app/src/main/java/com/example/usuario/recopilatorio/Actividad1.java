package com.example.usuario.recopilatorio;

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

public class Actividad1 extends AppCompatActivity {



    private Destino[] destinos = new Destino[]{
            new Destino("A", "Asia y Oceanía", 30, R.drawable.asia_oceania),
            new Destino("B","América y África", 20, R.drawable.africa),
            new Destino("C","Europa", 10, R.drawable.europa)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        final Bundle datos = new Bundle();
        final EditText pesoTV = (EditText) findViewById(R.id.pesoText);
        final String mensaje;
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Button calculos = (Button) findViewById(R.id.calculos);
        final RadioButton rB1 = (RadioButton) findViewById(R.id.normal);
        final RadioButton rB2 = (RadioButton) findViewById(R.id.urgente);
        final CheckBox chB1 = (CheckBox) findViewById(R.id.caja);
        final CheckBox chB2 = (CheckBox) findViewById(R.id.tarjeta);


        AdaptadorSpinnerZona <Destino> adaptadorSpin = new AdaptadorSpinnerZona(this);
        spinner.setAdapter(adaptadorSpin);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                datos.putSerializable("Continente", destinos[spinner.getSelectedItemPosition()]);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        calculos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String zona, tarifa = "Normal.", peso, decoracion = "Ninguna.", costeFinal = "";
                int posicion = spinner.getSelectedItemPosition();

                zona = destinos[posicion].getZona();
                if (rB2.isChecked()) {
                    tarifa = "Urgente.";
                }
                peso = pesoTV.getText().toString();
                if (chB1.isChecked() ) {
                    decoracion = "Con caja regalo.";
                } else if (chB2.isChecked()) {
                    decoracion = "Con dedicatoria.";
                } else if (chB2.isChecked() && chB1.isChecked()) {
                    decoracion = "Con caja regalo y dedicatoria.";
                }
                costeFinal = Double.toString(calcularPrecioFinal(calcularPrecioFinal(Double.parseDouble(peso))));

                datos.putString("Zona", zona);
                datos.putString("Tarifa", tarifa);
                datos.putString("Peso", peso);
                datos.putString("Decoracion", decoracion);
                datos.putString("Precio", costeFinal);

                Intent intent = new Intent(Actividad1.this, Actividad2.class);
                intent.putExtras(datos);
                startActivity(intent);
            }


        });
    }

    public double precioPeso(double peso) {
        if (peso >= 6.00 && peso <= 10.00) {
           peso= peso * 1.5;
        } if (peso>10.00){
            peso= peso * 2.00;
        }
        return peso;
    }

    public double calcularPrecioFinal(double peso) {
        double precioTotal = precioPeso(peso);
        if (rB2.isChecked())
            precioTotal= precioTotal + (precioTotal * 0.3);

        return precioTotal;

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.AcercaDe:
                Intent about = new Intent(Actividad1.this, AcercaDe.class);
                startActivity(about);
                return true;
            case R.id.Dibujo:
                Intent draw = new Intent(Actividad1.this, Dibujar.class);
                startActivity(draw);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    static class ViewHolder
    {
        TextView zona;
        TextView continente;
        TextView precio;
    }

    class AdaptadorSpinnerZona extends ArrayAdapter {

        Activity context;

        AdaptadorSpinnerZona(Activity context) {
            super(context, R.layout.spinner_layout, destinos);
            this.context = context;
        }

        public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
            return getView(posicion, convertView, parent);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            ViewHolder holder;

            if (item == null)
            {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.spinner_layout, null);

                holder = new ViewHolder();
                holder.zona = item.findViewById(R.id.zona);
                holder.continente = item.findViewById(R.id.continente);
                holder.precio = item.findViewById(R.id.precio);

                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.zona.setText(destinos[position].getZona());
            holder.continente.setText(destinos[position].getContinente());
            String a = Double.toString(destinos[position].getPrecio());
            holder.precio.setText(a);

            return (item);
        }

    }




}
