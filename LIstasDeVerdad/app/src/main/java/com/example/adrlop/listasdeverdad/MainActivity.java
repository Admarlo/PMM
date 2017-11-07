package com.example.adrlop.listasdeverdad;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Titular[]datos=new Titular[]{
        new Titular("Ragnar lothbrok","Travis Fimmel",R.drawable.ragnar),
        new Titular("Ladgerda lothbrok","Katheryn Winnick",R.drawable.lagertha),
        new Titular("Bjorn lothbrok","Alexander ludwig",R.drawable.biorn)
    };

    static class ViewHolder{
        TextView titulo;
        TextView subtitulo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador=new AdaptadorTitulares(this);
        ListView IstOpciones=(ListView)findViewById(R.id.LstOpciones);
        IstOpciones.setAdapter(adaptador);

        IstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int position,long id){
                String mensaje="Titulo: "+datos[position].getTitulo()+"Subtitulo: "+datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_LONG).show();
            }

                    public void onNothingSelected(AdapterView<?>adapterView){

            }

        });


    }



class AdaptadorTitulares extends ArrayAdapter{
    Activity context;

    AdaptadorTitulares(Activity context){
        super(context, R.layout.listitem_titular,datos);
        this.context=context;
    }
/*Mejora 2 de la lista*/
    public View getView(int i, View convertView, ViewGroup parent){
        View item=convertView;
        ViewHolder holder;
        if(item==null) {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(R.layout.listitem_titular, null);
            holder = new ViewHolder();
            holder.titulo = (TextView)item.findViewById(R.id.tvTitulo);
            holder.subtitulo = (TextView)item.findViewById(R.id.tvSubtitulo);
            item.setTag(holder);
        }

        else{
        holder = new ViewHolder();
        }

        holder.titulo.setText(datos[i].getTitulo());
        holder.subtitulo.setText(datos[i].getSubtitulo());

        return (item);
    }

}
}
