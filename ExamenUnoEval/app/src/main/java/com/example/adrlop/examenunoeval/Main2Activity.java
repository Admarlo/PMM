package com.example.adrlop.examenunoeval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle bundle = getIntent().getExtras();
        TextView tarifa = (TextView)findViewById(R.id.Precio);
        TextView ped = (TextView)findViewById(R.id.Pedido);
        TextView uni = (TextView)findViewById(R.id.Unidades);
        TextView coste = (TextView)findViewById(R.id.Coste);
        ImageView img = (ImageView)findViewById(R.id.imageView);
        nom =(TextView)findViewById(R.id.Pizza);

        pizzas = (Pizzas)bundle.getSerializable("PIZA");

        nom.setText(pizzas.getZona()+" : " +pizzas.getNombre());
        dec.setText(bundle.getString("EXTRA"));
        tar.setText(bundle.getString("TARIFA"));
        peso.setText(bundle.getString("UNIDADES"));
        coste.setText(bundle.getString("PRECIO"));
        img.setImageResource(pizzas.getFoto());

        registerForContextMenu(img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.showContextMenu();
            }  });

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        menu.setHeaderTitle(pizzas.getNombre());
        inflater.inflate(R.menu.menu_ctx, menu);
    }
}
