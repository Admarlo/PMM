package com.example.usuario.recopilatorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    private Destino destino;
    TextView continente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        Bundle bundle = getIntent().getExtras();
        TextView tarifa = (TextView)findViewById(R.id.tarifaTV);
        TextView decoracion = (TextView)findViewById(R.id.decoracionTV);
        TextView peso = (TextView)findViewById(R.id.pesoTV);
        TextView coste = (TextView)findViewById(R.id.costeTV);
        ImageView imagen = (ImageView)findViewById(R.id.imageView);
        continente =(TextView)findViewById(R.id.zonaTV);

        destino = (Destino)bundle.getSerializable("Continente");

        continente.setText(destino.getZona()+" : " + destino.getContinente());
        decoracion.setText(bundle.getString("Decoracion"));
        tarifa.setText(bundle.getString("Tarifa"));
        peso.setText(bundle.getString("Peso"));
        coste.setText(bundle.getString("Precio"));
        imagen.setImageResource(destino.getImagen());

        registerForContextMenu(imagen);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.showContextMenu();
            }  });

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle(destino.getContinente());
        inflater.inflate(R.menu.menu_contextual, menu);
    }
    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        continente = (TextView)findViewById(R.id.zonaTV);
        switch (itemMnuContex.getItemId()) {
            case R.id.Continente1:
                Intent intentone= new Intent(Actividad2.this, AsiaOceania.class);
                startActivity(intentone);
                return true;
            case R.id.Continente2:
                Intent intent= new Intent(Actividad2.this, AmericaAfrica.class);
                startActivity(intent);
                return true;
            case R.id.Continente3:
                Intent intent3= new Intent(Actividad2.this, Europa.class);
                startActivity(intent3);
                return true;

            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}
